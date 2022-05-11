import org.junit.Test;
import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;

public class DecodeTest {
    @Test
    public void test_simple_value(){
        assertEquals(Integer.decode("100"),new Integer(100));
    }

    @Test (expected = NumberFormatException.class)
    public void test_zero_length(){
        Integer.decode("");
    }

    @Test
    public void test_plus_minus_digit(){
        assertEquals(Integer.decode("-100"),new Integer(-100));
        assertEquals(Integer.decode("+100"),new Integer(100));
    }

    @Test
    public void test_hexadecimal_number_system(){
        assertEquals(Integer.decode("0xFFF"),new Integer(0xFFF));
        assertEquals(Integer.decode("0XFFF"),new Integer(0xFFF));
        assertEquals(Integer.decode("#FFF"),new Integer(0xFFF));
    }

    @Test
    public void test_octal_number_system(){
        assertEquals(Integer.decode("0777"),new Integer(0777));
        assertEquals(Integer.decode("0"),new Integer(0));
    }

    @Test (expected = NumberFormatException.class)
    public void test_second_plus(){
        Integer.decode("++100");
    }
    @Test (expected = NumberFormatException.class)
    public void test_second_minus(){
        Integer.decode("--100");
    }

    @Test (expected = NumberFormatException.class)
    public void test_integer_out_of_max_value(){
        Integer.decode(String.valueOf(Integer.MAX_VALUE + 1l));
    }
    @Test (expected = NumberFormatException.class)
    public void test_integer_out_of_min_value(){
        Integer.decode(String.valueOf(Integer.MIN_VALUE - 1l));
    }
}

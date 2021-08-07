package test.string;

import org.junit.Test;

/**
 * @ClassName TestString
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/6/13 19:50
 * @Version 1.0
 **/


public class TestString {

    @Test
    public void testString() {
        String str = "str";
        String str1 = "stR";
        System.out.println(str == str1);
        System.out.println(str.equals(str1));
        System.out.println(str.equalsIgnoreCase(str1));
    }


    @Test
    public void testStringBuilder() {
        StringBuilder sb = new StringBuilder();
    }

    @Test
    public void testStringBuffer() {
        StringBuffer stringBuffer = new StringBuffer();
        RuntimeException runtimeException = new RuntimeException();
    }
}

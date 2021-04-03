package sourceCode;

import java.util.List;

/**
 * @ClassName Test
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/4/1 19:54
 * @Version 1.0
 **/
public class Test implements Cloneable  {

    @org.junit.Test
    public void testString() {

        String str = new String("hello");
        System.out.println(str.hashCode());
        System.out.println(str);
        String str1 = "hello";
        String str2 = "hello";
        System.out.println(str == str1);  //false
        System.out.println(str.equals(str1));  //true
        System.out.println(str.compareTo(str1)); //0
        String intern = str.intern();  //true
        System.out.println(intern == str1);

        System.out.println(str1 == str2); //true
        StringBuilder sb = new StringBuilder();
        StringBuffer sbf = new StringBuffer();

        String string;
        System.out.println(string="123"); //123
        /*short s = 1;
        float f = 1.1;
        s = s + 1;
        s++;
        s += 1;
        System.out.println(s);

        final int x;
        x = 2;

        Object o;*/
        //List

    }
}

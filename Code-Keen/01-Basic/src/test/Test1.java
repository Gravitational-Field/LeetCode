package test;

import org.junit.Test;

/**
 * @ClassName Test1
 * @Description
 */
public class Test1 {


    @Test
    public void test1() {
        /*String st1 = "hello";
        String st2 = "hello";
        System.out.println(st1 == st2); // true
        System.out.println(st1.equals(st2)); // true*/


        /*String s1 = new String("aaa");
        String s2 = new String("aaa");
        System.out.println(s1 == s2); // false
        String s3 = s1.intern();
        String s4 = s2.intern();
        System.out.println(s3 == s4);  // true*/

        String str1 = new String("hello");
        String str2 = "hello";
        String str3 = str1.intern();
        System.out.println(str1 == str2); //false
        System.out.println(str1.equals(str2)); //true
        System.out.println(str2 == str3); //true


    }
}

package shein;

import java.util.Arrays;

/**
 * @ClassName shein2
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/7/14 19:56
 * @Version 1.0
 **/
public class shein2 {


    public int getFirstIndex(String str1,String str2) {
        String[] str2s = str1.split(str2);
        return str2s[0].length();

    }

    public static void main(String[] args) {
        String str1 = "shein";
        String str2 = "in";
        System.out.println(new shein2().getFirstIndex(str1, str2));

    }
}

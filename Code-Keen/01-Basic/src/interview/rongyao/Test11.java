package interview.rongyao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @ClassName Test11
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/8/14 18:13
 * @Version 1.0
 **/
public class Test11 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String str = in.next(); //cvjjap

            if (str.length() == 0) {
                return;
            }

            HashMap<Character, Integer> mapHigh = new HashMap<>();
            HashMap<Character, Integer> mapMid = new HashMap<>();
            HashMap<Character, Integer> mapLow = new HashMap<>();

            String high = "bdfhkl";
            char[] highChars = high.toCharArray();
            for (int i = 0; i < highChars.length; i++) {
                mapHigh.put(highChars[i], 0);
            }
            String mid = "aceimnorstuvwxz";
            char[] midChars = mid.toCharArray();
            for (int i = 0; i < midChars.length; i++) {
                mapMid.put(midChars[i], 0);
            }
            String low = "gjpqy";
            char[] lowChars = low.toCharArray();
            for (int i = 0; i < lowChars.length; i++) {
                mapLow.put(lowChars[i], 0);
            }

            //StringBuilder highResult = new StringBuilder();
            //StringBuilder midResult = new StringBuilder();
            //StringBuilder lowResult = new StringBuilder();
            //int[] ints = highResult.chars().toArray();


            String highResult = "";
            String midResult = "";
            String lowResult = "";

            //进行处理
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (mapHigh.containsKey(chars[i])) {
                    highResult += chars[i];
                } else if (mapMid.containsKey(chars[i])) {
                    midResult += chars[i];
                } else if (mapLow.containsKey(chars[i])) {
                    lowResult += chars[i];
                }
            }
            //highResult

            //highResult.getChars();
            char[] hr = highResult.toCharArray();
            Arrays.sort(hr);
            char[] mr = midResult.toCharArray();
            Arrays.sort(mr);
            char[] lr = lowResult.toCharArray();
            Arrays.sort(lr);


            //System.out.println(hr.length==0?);
            String result1 = "";
            String result2 = "";
            String result3 = "";

            for (char c : hr) {
                result1 += c;
            }
            for (char c : mr) {
                result2 += c;
            }
            for (char c : lr) {
                result3 += c;
            }
//cvjjap
//            System.out.println(result1);
//            System.out.println(result2);
//            System.out.println(result3);
//            System.out.println(new StringBuilder(Arrays.toString(mr)).toString());
            System.out.println(highResult.length() == 0 ? null : result1);
            System.out.println(midResult.length() == 0 ? null : result2);
            System.out.println(lowResult.length() == 0 ? null : result3);
        }


    }
}

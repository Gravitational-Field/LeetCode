package interview.shopee;
import java.util.*;
/**
 * @ClassName Luomashuzi2num
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/7/16 19:04
 * @Version 1.0
 **/
public class Luomashuzi2num {

    /**
     *
     * @param s string字符串
     * @return int整型
     */
    public int romanToInt (String s) {
        // write code here
        if(s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int result = 0;
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if(map.get(chars[i-1]) < map.get(chars[i])) {
                result -= map.get(chars[i-1]);
            } else {
                result += map.get(chars[i-1]);
            }
        }
        //遍历完成，加上最后的结果
        result += map.get(chars[chars.length-1]);
        return result;
    }

    public static void main(String[] args) {
        String str = "IV";
        System.out.println(new Luomashuzi2num().romanToInt(str));
    }
}

package leetcode;

import java.util.HashMap;
import java.util.Set;

/**
 * @ClassName L409
 * @Description: 最长回文串
 * @Author Keen
 * @DATE 2021/6/17 8:42
 * @Version 1.0
 **/
public class L409 {

    //思路：存到hashMap中<c,count>,遍历hash表，偶数位+；奇数位不管，最后加1
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 1) {
            return s.length();
        }
        //遍历，存到hashMap
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            //System.out.println(map.get(chars[i]) == null?0:map.get(chars[i]));
            map.put(chars[i], (map.get(chars[i]) == null ? 0 : map.get(chars[i])) + 1);
        }

        //遍历map
        Set<Character> keys = map.keySet();
        int sum = 0;
        int odd = 0; //是否有奇数
        for (Character c : keys) {
            if(map.get(c)%2 == 0) {
                sum += map.get(c);
            } else { //奇数
                //sum +=  (map.get(c)/2*2);//有多少个成对的
                sum = sum + map.get(c)-1;
                odd = 1;
            }
        }
        return sum+odd;
    }

    public static void main(String[] args) {
        String str = "abccccdd";
        /*Integer i = 11;
        System.out.println(i+1); //12
        System.out.println(i++); //11*/

        System.out.println(new L409().longestPalindrome(str));
        //System.out.println(11/2);
    }
}

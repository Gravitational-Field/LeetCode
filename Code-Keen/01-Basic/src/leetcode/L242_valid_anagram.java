package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName L242_valid_anagram
 * @Description
 */
public class L242_valid_anagram {

    // 该方法是最通常的解法
    public boolean isAnagram1(String s, String t) {

        char[] sarray = s.toCharArray();
        char[] tarray = t.toCharArray();
        Arrays.sort(sarray);
        Arrays.sort(tarray);
//        return Arrays.equals(sarray, tarray);
        return String.valueOf(sarray).equals(String.valueOf(tarray));  //更快
    }
    //使用hash表的思想：以数据方式
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] array = new int[26];
        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            array[s.charAt(i)-'a']--;
            if (array[s.charAt(i)-'a'] < 0) return false;
        }

        return true;
    }

    //使用hashmap的方式
    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)-1);

            if (map.get(ch) < 0) return false;
        }

        return true;
    }



    public static void main(String[] args) {
        String str1 = "a";
        String str2 = "b";

        System.out.println(new L242_valid_anagram().isAnagram3(str1, str2));
    }

}

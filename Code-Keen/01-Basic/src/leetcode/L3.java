package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName L3
 * @Description
 */
public class L3 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        char[] chars = s.toCharArray();

        int maxLength = 0;
        Set<Character> set = new HashSet<>();



        int rightIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            //右下标后移
            while (rightIndex < s.length() && !set.contains(chars[rightIndex])) {
                set.add(chars[rightIndex]);
                rightIndex++;
            }
            //右下边移到了重复的
            maxLength = Math.max(maxLength, set.size());  //rightIndex-i+1

            //左下标+1，并且移除chars[i]
            set.remove(chars[i]);

        }
        return maxLength;
    }

    public static void main(String[] args) {
        String  s = "abcabcbb";
        System.out.println(new L3().lengthOfLongestSubstring(s));
    }
}

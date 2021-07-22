package interview.shopee;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName Shpeee3
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/7/19 15:35
 * @Version 1.0
 **/
public class Shpeee3 {

    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     * <p>
     * <p>
     * find min override sub string
     *
     * @param source string字符串
     * @param target string字符串
     * @return string字符串
     */
    Map<Character, Integer> map1 = new HashMap<>();
    Map<Character, Integer> map2 = new HashMap<>();

    public String findMinOverrideSubString(String source, String target) {
        if(source == null || target == null|| source.length() == 0 || target.length() == 0) {
            return "";
        }
        // write code here
        int tLen = target.length();
        int sLen = source.length();
        for (int i = 0; i < tLen; i++) {
            char c = target.charAt(i);
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        int l = 0;
        int r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;

        while (r < sLen) {
            ++r;
            if (r < sLen && map1.containsKey(source.charAt(r))) {
                map2.put(source.charAt(r), map2.getOrDefault(source.charAt(r), 0) + 1);
            }
            while (isContain() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (map1.containsKey(source.charAt(l))) {
                    map2.put(source.charAt(l), map2.getOrDefault(source.charAt(l), 0) - 1);
                }
                ++l;
            }
        }

        return ansL == -1?"":source.substring(ansL,ansR);
    }


    private boolean isContain() {
        Iterator<Map.Entry<Character, Integer>> iter = map1.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Character, Integer> entry = iter.next();
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (map2.getOrDefault(key, 0) < value) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String source = "abcd", target = "bcd";
        System.out.println(new Shpeee3().findMinOverrideSubString(source, target));
    }
}

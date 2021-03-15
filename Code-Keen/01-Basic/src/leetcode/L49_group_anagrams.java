package leetcode;

import java.util.*;

/**
 * @ClassName L49_group_anagrams
 * @Description
 */
public class L49_group_anagrams {


    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return null;

        List<List<String>> resultList = new LinkedList<>();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] == null) continue;
            //从头往后判断，如果异位，则添加进去
            List<String> itemList = new LinkedList<>();
            for (int j = strs.length-1; j > i; j--) {
                if (strs[j]!=null && isYiWei(strs[i],strs[j])) {
                    //是异位词
                    itemList.add(strs[j]);
                    strs[j] = null;
                }
            }
            itemList.add(strs[i]);
            resultList.add(itemList);
        }
        return resultList;
    }

    private boolean isYiWei(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return String.valueOf(chars1).equals(String.valueOf(chars2));
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        if (strs == null || strs.length == 0) return null;
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            //存
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String str = Arrays.toString(chars);
            List<String> list = map.getOrDefault(str, new ArrayList<>());
            list.add(strs[i]);
            map.put(str, list);
        }
        return new ArrayList<>(map.values());
    }


    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> resultList = new L49_group_anagrams().groupAnagrams1(strs);
        for (List<String> list:resultList) {
            System.out.println(list);
        }

    }

}

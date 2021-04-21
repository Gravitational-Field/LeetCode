package leetcode;

import java.util.*;

/**
 * @ClassName L17
 * @Description: 电话号码的字母组合
 * @Author Keen
 * @DATE 2021/4/5 20:10
 * @Version 1.0
 **/
public class L17 {
    public Map<Character, String> map = new HashMap<>();
    public List<String> resList = new ArrayList<>();

    public L17() {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    //全排列
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) {
            return resList;
        }
        char[] chars = digits.toCharArray();
        build(chars,"", 0);
        return resList;
    }

    private void build(char[] chars, String tmp, int index) {
        if(index == chars.length) {
            resList.add(tmp);
            //System.out.println(tmp);
            return;
        }

        String letters = map.get(chars[index]);

        //每轮取一个
        for (int i = 0; i < letters.length(); i++) { //控制
            build(chars, tmp+letters.charAt(i), index+1);
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        L17 l17 = new L17();
        l17.letterCombinations(digits);
        System.out.println(Arrays.toString(l17.resList.toArray()));
    }
}


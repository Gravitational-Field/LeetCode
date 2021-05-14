package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName L22_2
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/5/12 9:15
 * @Version 1.0
 **/
public class L22_2 {
    public List<String> generateParenthesis(int n) {
        //dp链表
        LinkedList<LinkedList<String>> result = new LinkedList<LinkedList<String>>();
        LinkedList<String> list0 = new LinkedList<String>();
        list0.add("");
        result.add(list0);
        if (n == 0) return result.get(0);
        LinkedList<String> list1 = new LinkedList<String>();
        list1.add("()");
        result.add(list1);  // "(" + 【i=p时所有括号的排列组合】 + ")" + 【i=q时所有括号的排列组合】
        for (int i = 2; i <= n; i++) {  //开始遍历 p q ，其中p+q=i-1 , j 作为索引
            LinkedList<String> temp = new LinkedList<String>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = result.get(j);  // p = j 时的括号组合情况
                List<String> str2 = result.get(i - 1 - j); // q = (i-1) - j 时的括号组合情况
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        String el = "(" + s1 + ")" + s2;
                        temp.add(el);
                    }
                }

            }
            result.add(temp);
        }
        return result.get(n);
    }

    public static void main(String[] args) {
        LinkedList<LinkedList<String>> result = new LinkedList<LinkedList<String>>();
        LinkedList<String> list0 = new LinkedList<String>();
        list0.add("");
        result.add(list0);
        System.out.println(result.get(0));
    }
}

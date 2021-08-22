package interview.wangyi;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @ClassName Test2
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/8/21 15:32
 * @Version 1.0
 **/
public class Test2 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 返回Sn的第k位字符
     * @param n int整型 Sn的n
     * @param k int整型 需要返回的字符下标位
     * @return char字符型
     */
    public char findKthBit (int n, int k) {
        // write code here
        if(n == 1) {
            return 'a';
        }
        //初始化
        S.add("a");
        char L1 = 'a';
        int i;
        for (i = 1; S.get(i-1).length()<k ; i++) { //i<k && i < n
            //构建String
            char li =  (char)(L1+i);
            String reverseStr = invert(S.get(i-1));
            String si = S.get(i-1)+li+reverseStr;
            S.add(i,si);
        }
        //String str = S.get(i-1);
        return S.get(i-1).toCharArray()[k-1];
    }

    private String invert(String s) {//字符反转
        StringBuilder res = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.toCharArray().length; i++) {
            res.append((char)('a'+'z'-chars[i]));
        }
        return res.reverse().toString();
    }

    public static ArrayList<String> S = new ArrayList<>();

    public static void main(String[] args) {
        int n= 3,k = 3;
        System.out.println(new Test2().findKthBit(n,k));
    }
}

package leetcode;

import java.util.Arrays;

/**
 * @ClassName L633
 * @Description: 平方数之和
 * @Author Keen
 * @DATE 2021/7/16 21:35
 * @Version 1.0
 **/
public class L633 {

    public boolean judgeSquareSum(int num) {
        for (int i = 0; i < Math.sqrt(num)+1; i++) {
            for (int j = 0; j <= i; j++) {
                if(i*i+j*j == num) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int num = 13;
        System.out.println(new L633().judgeSquareSum(num));
    }
}

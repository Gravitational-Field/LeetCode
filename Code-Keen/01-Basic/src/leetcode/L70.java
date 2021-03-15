package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName L70
 * @Description
 */
public class L70 {

    public int climbStairs(int n) {
        Integer[] array = new Integer[n+1];
        Arrays.fill(array,1);

        array[1] = 1;
        array[2] = 2;
        dp(n,array);
        return array[n];

    }

    //功能为得到n的方法
    private void dp(int n, Integer[] array) {

        if (array[n-1] == n+1) {
            //说明没有计算过
            dp(n-1,array);
        }
        if (array[n-2] == n+1) {
            //说明没有计算过
            dp(n-2,array);
        }

        array[n] = array[n-1] + array[n-2];
    }


    public static void main(String[] args) {
        System.out.println(new L70().climbStairs(5));
//        Integer[] array = new Integer[31];
//        System.out.println(Arrays.asList(array));
    }
}

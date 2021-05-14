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

    //直接递归
    public int climbStairs1(int n) {
        if(n == 1 || n == 2) {
            return n;
        }
        return climbStairs1(n-1)+climbStairs1(n-2);
    }


    static int[] array;  //默认内部为0
    public int climbStairs2(int n) {
        if( n == 1 || n == 2) {
            return n;
        }
        array = new int[n+1];
        array[1] = 1;
        array[2] = 2;

        process(n);
        return array[n];
    }

    private void process(int n) {
        if(array[n-2] == 0) {
            process(n-2);
        }
        if(array[n-1] == 0) {
            process(n-1);
        }
        array[n] = array[n-1]+array[n-2];
    }

    public int climbStairs3(int n) {
        if( n == 1 || n == 2) {
            return n;
        }
        array = new int[n+1];
        array[1] = 1;
        array[2] = 2;

        //迭代处理
        for (int i = 3; i <= n; i++) {
            array[i] = array[i-2] + array[i-1];
        }

        return array[n];
    }


    public int climbStairs4(int n) {
        if( n == 1 || n == 2) {
            return n;
        }
        int p = 1;
        int q = 2;
        int z = -1;

        //迭代处理
        for (int i = 3; i <= n; i++) {
             z = p+q;
             p = q;
             q = z;
        }
        return q;
    }





    public static void main(String[] args) {
        System.out.println(new L70().climbStairs4(3));
        array = new int[1];
        System.out.println(Arrays.toString(array));
//        Integer[] array = new Integer[31];
//        System.out.println(Arrays.asList(array));
    }
}

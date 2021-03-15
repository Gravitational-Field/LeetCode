package jianzhioffer;

import java.util.Arrays;

/**
 * @ClassName J10_1
 * @Description
 */
public class J10_1 {

    //纯递归，会超出时间限制
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        return fib(n-1)+fib(n-2);
    }

    //带备忘录的递归
    public int fib1(int n) {
        //备忘录数组
        Integer[] array = new Integer[n+1];
        Arrays.fill(array,-1);

        return process(n,array);
    }

    private int process(int n, Integer[] array) {
        if (n==0) return 0;
        if (n==1) return 1;
        if (array[n] != -1) {  //巧妙之处
            return array[n];
        }
        array[n] = (process(n-1,array) + process(n-2,array))%1000000007;

        return array[n];
    }

    //dp数组迭代解法
    public int fib2(int n) {
        if (n==0) return 0;
        if (n==1) return 1;
        //备忘录数组
        Integer[] array = new Integer[n+1];
        Arrays.fill(array,-1);

        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i <= n; i++) {
            array[i] = (array[i-1] + array[i-2])%1000000007;
        }
        return array[n];
    }

    //dp解法，压缩空间
    public int fib3(int n) {
        if (n==0) return 0;
        if (n==1) return 1;
        //备忘录数组
        int a = 0;
        int b = 1;
        int fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = (a+b)%1000000007;
            a = b;
            b = fib;
        }
        return b;
    }







}

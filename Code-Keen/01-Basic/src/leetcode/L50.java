package leetcode;

import java.math.BigDecimal;

/**
 * @ClassName L50
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/3/30 12:08
 * @Version 1.0
 **/
public class L50 {

    /*public double myPow(double x, int n) {
        double res = 1.0;
        if (n == 0) {
            return 1.0;
        } else if (n < 0) {
            x = 1 / x;
            n = -n;
        } else {
            res = x;
        }

        while (--n != 0) {
            res *= x;
        }
        return res;
    }*/


    public double myPow(double x, int n) {
        long num = n;

        return num<=0?1/build(x,-num):build(x,num);

    }

    private double build(double x, long n) {
        double res = 1.0;
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1/x;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double half = build(x, n/2);
        double rest = build(x, n%2);
        return half*half*rest;

    }


    public static void main(String[] args) {
        /*double x = 2.0000;
        int n = 10;*/
        double x = 2.00000;
        int n = -2147483648;
        System.out.println(new L50().myPow(x, n));
    }
}

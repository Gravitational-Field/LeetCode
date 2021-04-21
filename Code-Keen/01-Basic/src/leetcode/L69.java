package leetcode;

/**
 * @ClassName L69
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/4/19 13:39
 * @Version 1.0
 **/
public class L69 {

    //暴力解法
    public int mySqrt(int x) {
        int i = x / 2 + 1;
        for (long j = 0; j <= i; j++) {
            if (j * j == x) {
                //找到了
                return (int) j;
            } else if (j * j > x) {
                return (int) j - 1;
            }
        }
        return -1;
    }

    public int mySqrt1(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int left = 1;
        int right = x / 2;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    int s;

    //牛顿迭代法
    public int mySqrt3(int x) {
        s = x;
        s=x;
        if(x==0) return 0;
        return ((int)(sqrts(x)));
    }

    public double sqrts(double x){
        double res = (x + s / x) / 2;
        if (res == x) {
            return x;
        } else {
            return sqrts(res);
        }
    }

    public int mySqrt4(int x) {
        long s = x;
        while (s*s > x) {
            s = (s+x/s)/2;
        }
        return (int)s;
    }


    public static void main(String[] args) {
        int x = 2147395599;
        System.out.println(new L69().mySqrt4(x));
        //System.out.println(Integer.MAX_VALUE);
    }
}

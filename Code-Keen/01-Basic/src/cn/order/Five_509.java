package cn.order;

public class Five_509 {

    public int fib(int n) {
        int a = 0;
        int b = 1;
        int c = a+b;
        int sum = Integer.MIN_VALUE;
        if(n == 0) return 0;
        for (int i = 1; i < n+1; i++) {
            if(i == 1) {
                sum = 1;
            } else {
                sum = c;
                a = b;
                b = c;
                c = a +b;
            }
        }

        return sum;
    }


}

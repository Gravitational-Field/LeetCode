package test;

import java.util.Scanner;

/**
 * @ClassName Test2
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/3/21 21:01
 * @Version 1.0
 **/
public class Test2 {

    static int len = 0, sum = 0;
    static int s;
    static int n;
    static int u;
    static int v;
    static int t;
    static int m;
    static Integer min = Integer.MAX_VALUE;
    static  int step[] = new int[100];

    static void compute(int stair) {
        if (stair < 0){
            return;
        }
        //表示已经走完了
        if (stair == 0) {
            printSum();
            sum++;
            return;
        }
        //每次到下一步选择时都可以走1-2步
        for (int i = 1; i <= 2; i++) {
            step[len] = i;
            len++;
            //进行下一步的迭代，迭代完之后将每后加上的一步去掉，换成其它的步数(如从1换成2)
            compute(stair - i);
            len--;
        }
    }

    static void printSum() {
        //System.out.print("走法:");
        int x = 0;
        int y = 0;
        for (int i = 0; i < len; i++) {
            if(step[i] == 1) {
                x++;
            }
            if(step[i] == 2) {
                y++;
            }
        }

        if(getTili(s, t, x, y) <= m) {
            min = Math.min(getTime(u, v, x, y),min);
        }
    }

    private static int getTime(int u, int v, int x, int y) {
        return u*x+v*y;
    }

    private static int getTili(int s, int t, int x, int y) {
        return s*x+t*y*y;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = Integer.valueOf(sc.next());
        u = Integer.valueOf(sc.next());
        v = Integer.valueOf(sc.next());
        s = Integer.valueOf(sc.next());
        t = Integer.valueOf(sc.next());
        m = Integer.valueOf(sc.next());

        //int step[] = new int[n];
        compute(n);
        System.out.println(min);
    }
}

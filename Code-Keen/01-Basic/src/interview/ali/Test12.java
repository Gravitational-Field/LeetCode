package interview.ali;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Test1
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/8/27 19:01
 * @Version 1.0
 **/
public class Test12 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long k = sc.nextLong();
        int[] a = new int[n];

        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);

        int orginMax = a[n-1];

        long extra = 0;
        for (int i = 0; i < n; i++) {
            if(a[i] < orginMax) {
                extra += orginMax-a[i];
            }
        }

        if(k <= extra) {
            System.out.println(orginMax);
            return;
        }

        long diff = k-extra;
        //Arrays.fill(a, orginMax);
        //往上添加

        long layer = diff/n;
        long yushu = diff%n;
        if(yushu == 0) {
            System.out.println(orginMax+layer);
        } else {
            System.out.println(orginMax+layer+1);
        }

    }
}

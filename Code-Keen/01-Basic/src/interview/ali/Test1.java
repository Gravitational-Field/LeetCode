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
public class Test1 {

    public static void main(String[] args) {
        //3 3
        //1 2 3
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }

        int[] b = new int[n];
        System.arraycopy(a,0, b, 0, n);
        //System.out.println(Arrays.toString(b));
        Arrays.sort(b);

        int orginMax = b[n-1];

        int extra = 0;
        for (int i = 0; i < b.length; i++) {
            if(b[i] < orginMax) {
                extra += orginMax-b[i];
            }
        }
        //System.out.println("extra:" + extra);

        if(k <= extra) {
            System.out.println(orginMax);
            return;
        }

        int diff = k-extra;
        Arrays.fill(b, orginMax);
        //System.out.println(Arrays.toString(b));
        //往上添加

        int layer = diff/n;
        int yushu = diff%n;
        if(yushu == 0) {
            System.out.println(orginMax+layer);
        } else {
            System.out.println(orginMax+layer+1);
        }

    }
}

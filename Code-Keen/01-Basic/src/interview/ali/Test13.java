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
public class Test13 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long k = sc.nextLong();
        int[] a = new int[n];

        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);

        int orginMax = 0;
        int maxId = 0;

        /*for (int i = 0; i < n; i++) {
            if(a[i]) {

            }



        }*/

    }
}

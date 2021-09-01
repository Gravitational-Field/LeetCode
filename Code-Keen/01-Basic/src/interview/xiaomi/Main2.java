package interview.xiaomi;

import java.util.Scanner;

/**
 * @ClassName Main2
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/9/1 19:54
 * @Version 1.0
 **/
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxSize = sc.nextInt();
        int M = 3;
        int[] a = new int[maxSize];
        int i,j;
        for (i = 0; i < M; i++) {
            a[i] = 0;
        }

        int flag = 0;
        for (i = 0,j=0; i < M && flag<M-1; i++) {
            if(a[i] == 0) {
                ++j;
                if(j==maxSize) {
                    j=0;
                    a[i] = 1;
                    flag++;
                }
            }
        }
        System.out.println(i+1);
    }
}

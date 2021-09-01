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
public class Test2 {

//3 3
//000
//101
//000
//4
//1 1
//1 3
//3 1
//3 3
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] dmap = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            //System.out.println(str);
            for (int j = 0; j < m; j++) {
                //遍历输入的字符串
                dmap[i][j] = Integer.valueOf(str.toCharArray()[j]-'0');
            }
        }

/*        for (int i = 0; i < dmap.length; i++) {
            System.out.println(Arrays.toString(dmap[i]));
        }*/

        int k = sc.nextInt();

        for (int i = 0; i < k; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            dmap[x][y] = 2;
        }


        System.out.println(-1);
    }

}

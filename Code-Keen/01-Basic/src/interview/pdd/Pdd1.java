package interview.pdd;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Pdd1
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/7/25 19:05
 * @Version 1.0
 **/
public class Pdd1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int[][] arr = new int[count][2];
        int row = 0;
        while (count > 0 && in.hasNextInt()) {
            //while () {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            int b = in.nextInt();
            arr[row][0] = a;
            arr[row][1] = b;
            //System.out.println(a + b);
            row++;
            count--;
        }
        //构建完成
        boolean flag = true;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j<arr.length; j++) {
                if(flag&&contains(arr[i][0],arr[i][1],arr[j][0],arr[j][1])) {
                    flag = false;
                    System.out.println(true);
                    break;
                }
            }
        }
        if(flag) {
            System.out.println(false);
        }

        //System.out.println(contains(1,3,4,5));

        /*for (int[] a : arr) {
            System.out.print(Arrays.toString(a));
        }*/
    }

        /*4
        1 3
        4 5
        7 10
        13 18*/
    public static boolean contains(int a, int b, int c, int d) {

        if (a == c) {
            //是否前包含后
            return true;
        } else if(a > c && b<=d) {
            return true;
        } else if(a < c && b>=d) {
            return true;
        }
        return false;
    }


}

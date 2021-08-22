package interview.xiaohongshu;

import java.util.Scanner;

/**
 * @ClassName lujingsearch
 * @Description: dfs,进行遍历，探测有多少种情况
 * @Author Keen
 * @DATE 2021/8/21 10:50
 * @Version 1.0
 **/
public class lujingsearch {

    public static int res = 0;
    public static int people = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()) {
            int N = sc.nextInt();
            char[][] arr = new char[N][N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.next().toCharArray();
            }

            /*for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(arr[i][j]);
                }
                System.out.println();
            }*/

            method(arr);
            System.out.println(res);
            System.out.println(people);

        }

    /*..#
        ..#
        ...*/

    }

    private static void method(char[][] arr) {
        if(arr == null || arr.length == 0) {
            return;
        }
        if(arr.length == 1) {
            res = 1;
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] != '#') {
                    people++;
                }
            }
        }

        dfs(arr,0,0,1);
        return;
    }

    private static void dfs(char[][] arr, int i, int j, int num) {
        if(i<0||i>=arr.length||j<0||j>=arr[0].length||arr[i][j]!='.') {
            return;
        }
        
        if(num == people && i == arr.length-1) {
            res++;
            return;
        }

        arr[i][j] = '#';
        dfs(arr, i+1, j, num+1);
        dfs(arr, i-1, j, num+1);
        dfs(arr, i, j+1, num+1);
        dfs(arr, i, j-1, num+1);
        arr[i][j] = '.';

        return;
    }


}

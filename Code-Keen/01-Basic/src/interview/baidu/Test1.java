package interview.baidu;

import java.util.Arrays;

/**
 * @ClassName Test1
 * @Description dp方式解决左上到右下
 */
public class Test1 {

    public int getPath(int m, int n) {
        int[][] dp= new int[m][n];
        //基础状态处理
        //处理最后一列,列不变，行变
        for (int i = 0; i < m; i++) {
            dp[i][n-1] = 1;
        }
        //处理最后一行，行不变，列变
        for (int i = 0; i < n; i++) {
            dp[m-1][i] = 1;
        }
        //进行递归,来填充dp数组
        recursion(0, 0, dp);
        for (int[] array:dp) {
            System.out.println(Arrays.toString(array));
        }
        return dp[0][0];
    }

    //进行递归，计算[i,j]到[m-1,n-1]的路径条数
    private int recursion(int i, int j, int[][] dp) {
        //不需要进行这个结束判断

        if(dp[i][j] == 0) {
            dp[i][j] = recursion(i + 1, j, dp) + recursion(i, j + 1, dp);
        }
        return dp[i][j];
    }

    public static void main(String[] args) {
        System.out.println(new Test1().getPath(3,4));
    }
}

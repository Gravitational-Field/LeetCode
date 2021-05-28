package leetcode;

import java.util.Arrays;

/**
 * @ClassName L63
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/5/27 20:59
 * @Version 1.0
 **/
public class L63 {

    //自底向上的方式：动态规划
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        //创建dp数组
        int[][] dp = new int[m][n];
        //构建基本状态
        for (int i = 0; i < dp.length;i++) {
            if(obstacleGrid[i][0]==1) {
                break;
            }
            dp[i][0] = 1;
        }
        for (int i = 0; i < dp[0].length; i++)  {
            if(obstacleGrid[0][i]==1) {
                break;
            }
            dp[0][i] = 1;
        }
        //递推：dp[i][j] = dp[i-1][j]+dp[i][j-1]  但要排除obstacleGrid[i][j] == 1
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }



    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 1},
                                {0, 0}};
        System.out.println(new L63().uniquePathsWithObstacles(obstacleGrid));

        /*for (int[] array:dp) {
            System.out.println(Arrays.toString(array));
        }*/
    }

}

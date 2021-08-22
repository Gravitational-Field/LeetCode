package interview.wangyi;

public class Test4 {

    public int minSailCost(int[][] num) {
        int m = num.length;
        int n = num[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (num[i][j] == 2) {
                    num[i][j] = 99999;
                } else {
                    num[i][j] = 2;
                }
            }
        }

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j != 0) {
                    dp[i][j] = num[i][j] + dp[i][j - 1];
                } else if (i != 0 && j != 0) {
                    dp[i][j] = num[i][j] + dp[i - 1][j];
                } else if (i != 0) {
                    dp[i][j] = num[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int [][] num = {{1,1,1,1,0},
        {0, 1, 0, 1, 0},{1,1,2,1,1,},{0,2,0,0,1}};
        System.out.println(new Test4().minSailCost(num));

    }
}

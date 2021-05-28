package leetcode;

import java.util.Arrays;

/**
 * @ClassName L1143
 * @Description: 最长公共子序列
 * @Author Keen
 * @DATE 2021/5/27 9:52
 * @Version 1.0
 **/
public class L1143 {

    //有时这种方式不太好理解
    public int longestCommonSubsequence1(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        System.out.println("++++++++++++++++++++++++++++++++++++++++++");
        for (int[] array : dp) {
            System.out.println(Arrays.toString(array));
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++");
        for (int[] array : dp) {
            System.out.println(Arrays.toString(array));
        }
        return dp[m][n];
    }

    //应用空格技巧的动态规划
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        text1 = " "+text1;
        text2 = " "+text2;
        int[][] dp = new int[m+1][n+1];

        //dp数组初始化
        //Arrays.fill(dp);

        for (int i = 0; i < m+1; i++) dp[i][0] = 1; //行变列不变
        for (int i = 0; i < n+1; i++) dp[0][i] = 1; //列变行不变

        //进行递推
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if(text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[m][n]-1;
    }


    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";
        System.out.println(new L1143().longestCommonSubsequence(text1, text2));
        /*System.out.println("++++++++++++++++++++++++++++++++++++++++++");
        for (int[] array : dp) {
            System.out.println(Arrays.toString(array));
        }*/
    }

}

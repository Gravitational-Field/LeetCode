package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName L354
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/6/28 13:45
 * @Version 1.0
 **/
public class L354 {

    public int maxEnvelopes(int[][] envelopes) {
        //System.out.println(Arrays.toString(envelopes));
        for (int[] arr : envelopes) { //[5,4][6,4][6,7][2,3]
            System.out.print("[" + arr[0] + "," + arr[1] + "]");
        }
        System.out.println();
        //先排序
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int len = envelopes.length;

        int[] dp = new int[len];
        Arrays.fill(dp, 1); //用1进行填充

        //构建dp数组中的每一个值
        for (int i = 0; i < len; i++) {
            //负责填充dp[i]->dp[nums.length-1]
            for (int j = 0; j < i; j++) {//确定每一个dp[i]的值
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        //获取最长子序列长度：即为dp数组的最大值
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        for (int[] arr : envelopes) { //[2,3][5,4][6,4][6,7]
            System.out.print("[" + arr[0] + "," + arr[1] + "]");
        }
        System.out.println();
        return res;
    }

    public static void main(String[] args) {
        //int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        int[][] envelopes = {{4, 5},{4, 6},{ 6, 7 },{2, 3},{1, 1}};
        System.out.println(new L354().maxEnvelopes(envelopes));
    }
}

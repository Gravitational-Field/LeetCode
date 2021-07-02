package jianzhioffer;

import java.util.Arrays;

/**
 * @ClassName J42
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/6/28 18:53
 * @Version 1.0
 **/
public class J42 {
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        // dp[i]:代表以nums[i]为尾的最大连续子数组的和,最终遍历一遍
        //另一种表现含义：dp[i]:第i位时的最大连续子数组的和，最终返回dp[n-1]
        //初始状态：全都为0
        dp[0] = nums[0];
        //dp[i] = Math.max(dp[i-1],)
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
        }
        System.out.println(Arrays.toString(dp));

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = res>dp[i]?res:dp[i];
        }
        return res;
    }

    public static void main(String[] args) {
        //int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums = {1};
        System.out.println(new J42().maxSubArray(nums));
    }
}

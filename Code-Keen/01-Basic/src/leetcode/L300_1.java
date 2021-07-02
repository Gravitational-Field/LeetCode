package leetcode;

import java.util.Arrays;

/**
 * @ClassName L300_1
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/6/26 22:09
 * @Version 1.0
 **/
public class L300_1 {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length<=1) {
            return 1;
        }
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;

        for (int i = 1; i < len; i++) {
            for (int j = i; j >= 0; j--) { //错误，应该是从左到右，最大的子序列+1，这里就不修改了，参照L300即可
                if(nums[j]<nums[i]) {
                    dp[i] = dp[j]+1;
                    break;
                } else {
                    dp[i] = 1;
                }
            }
        }
        System.out.println(Arrays.toString(dp));

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            max = max>dp[i]?max:dp[i];
        }
        return max;
    }

    public static void main(String[] args) {
        //int [] nums = {10,9,2,5,3,7,101,18};
        int[] nums = {0,1,0,3,2,3};
        System.out.println(new L300_1().lengthOfLIS(nums));
    }
}

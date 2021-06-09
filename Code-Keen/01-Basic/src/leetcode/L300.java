package leetcode;

import java.util.Arrays;

/**
 * @ClassName L300
 * @Description
 */
public class L300 {

    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int[] dp = new int[nums.length];
        Arrays.fill(dp,1); //用1进行填充

        //构建dp数组中的每一个值
        for(int i=0; i<nums.length; i++) {
            //负责填充dp[i]->dp[nums.length-1]
            for(int j=0; j<i; j++) {//确定每一个dp[i]的值
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }

        //获取最长子序列长度：即为dp数组的最大值
        int res = 0;
        for(int i = 0; i<dp.length; i++) {
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(new L300().lengthOfLIS(nums));
    }
}

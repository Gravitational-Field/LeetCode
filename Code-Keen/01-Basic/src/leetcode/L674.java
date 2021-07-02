package leetcode;

import java.util.Arrays;

/**
 * @ClassName L674
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/6/26 22:21
 * @Version 1.0
 **/
public class L674 {

    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        //dp[i]: 代表到达nums[i]当前这个值时，最大连续递增子序列为dp[i],最终结果还要从中找最大
        //而不是前[0,i]位的最大连续递增子序列
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            if(nums[i] > nums[i-1]) {
                dp[i] = dp[i-1]+1;
            } else {
                dp[i] = 1;
            }
        }
        //遍历查找最大
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = dp[i]>max?dp[i]:max;
        }
        return max;
    }

    public int findLengthOfLCIS1(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return nums.length;
        }

        int count = 0;
        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] <= nums[i-1]) {
                start = i;
            }
            count = Math.max(count, i-start+1);
        }
        return count;
    }


    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        System.out.println(new L674().findLengthOfLCIS1(nums));
    }
}

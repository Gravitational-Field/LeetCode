package leetcode;

import java.util.Arrays;


/**
 * @ClassName L239
 * @Description
 */
public class L239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int len = nums.length;
        //需要的返回数组的大小
        int[] resArray = new int[len-k+1];
        System.out.println(resArray.length);
        int q1= 0;
        for (int i = 0; i < resArray.length; i++) {
            //每次确定一个值，放到resArray中
            //k个中遍历取最大
            int k_max = findMax(nums, q1++, k); //
            resArray[i] = k_max;
        }
//        Arrays.sort(nums);
        return resArray;
    }

    private int findMax(int[] nums, int q1, int k) {
        int max = Integer.MIN_VALUE;
        for (int i = q1; i < q1+k; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {3,25,44,1,6,8,6};
        int k = 3;
        System.out.println(Arrays.toString(new L239().maxSlidingWindow(nums, k)));

    }
}

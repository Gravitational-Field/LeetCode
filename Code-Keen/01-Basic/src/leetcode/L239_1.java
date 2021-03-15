package leetcode;

import java.util.Arrays;

/**
 * @ClassName L239_1
 * @Description
 */
public class L239_1 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int len = nums.length;
        //需要的返回数组的大小
        int[] resArray = new int[len-k+1];
        System.out.println(resArray.length);
        int q1= 0;
        int k_max = Integer.MIN_VALUE;
        for (int i = 0; i < resArray.length; i++) {
            //每次确定一个值，放到resArray中
            //进行优化，依赖每次增加一个位置，减少一个位置

            //k个中遍历取最大
            k_max = findMax(nums, q1++, k, k_max); // 传入先前最大值，进行比较
            resArray[i] = k_max;
        }
        return resArray;
    }

    private int findMax(int[] nums, int q1, int k, int k_max) {
        int max = Integer.MIN_VALUE;
        if (q1>0 && q1+k<nums.length) {
            //满足要求
            if (nums[q1-1] != k_max) {
                //刚移除的不是最大值，k_max与新添加的值对比
                if (nums[q1+k-1] > k_max) {
                    return nums[q1+k-1];
                } else {
                    return  k_max;
                }
            }
        }

        for (int i = q1; i < q1+k; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(new L239_1().maxSlidingWindow(nums, k)));

    }
}

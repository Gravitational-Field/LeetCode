package leetcode;

/**
 * @ClassName L494
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/3/16 8:16
 * @Version 1.0
 **/
public class L494 {
    //public int count = 0;

    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        calculate(nums, 0, 0, S);
        return count;
    }
    public void calculate(int[] nums, int i, int sum, int S) {
        if (i == nums.length) {
            if (sum == S)
                count++;
        } else {
            calculate(nums, i + 1, sum + nums[i], S);
            calculate(nums, i + 1, sum - nums[i], S);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int S = 3;
        System.out.println(new L494().findTargetSumWays(nums, S));

    }

}

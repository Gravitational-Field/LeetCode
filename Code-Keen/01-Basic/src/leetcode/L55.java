package leetcode;

/**
 * @ClassName L45
 * @Description: 跳跃游戏1: 判断是否能达到最后一个小标
 * @Author Keen
 * @DATE 2021/4/12 22:32
 * @Version 1.0
 **/
public class L55 {
    
    boolean[] flags;
    //1. 采用
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        int len = nums.length;
        int maxGet = 0;
        for (int i = 0; i < len; i++) {
            if(i <= maxGet) {
                //能够到达
                maxGet = Math.max(maxGet, i+nums[i]);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] array = {3, 2, 1, 0, 4};
        System.out.println(new L55().canJump(array));
    }
}

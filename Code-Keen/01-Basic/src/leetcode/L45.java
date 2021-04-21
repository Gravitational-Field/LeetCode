package leetcode;

/**
 * @ClassName L45
 * @Description: 跳跃游戏2
 * @Author Keen
 * @DATE 2021/4/12 22:32
 * @Version 1.0
 **/
public class L45 {

    //反向查找，查找第一个离终点最近的点
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int end = nums.length-1;
        int step = 0;

        while (end > 0) {
            for (int i = 0; i < end; i++) {
                if (i + nums[i] >= end) {
                    end = i;
                    step++;
                    break;
                }
            }
        }
        return step;
    }

    //正向贪心查找
    public int jump1(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int step = 0;
        int locMax = 0;
        int end = 0;  //记录当前边界


        //作用：探索当前能够达到的最大
        for (int i = 0; i < nums.length-1; i++) {
            locMax = Math.max(locMax, i+nums[i]);
            if(i == end) { //到达边界
                step++;
                end = locMax;  //新边界变为当前能够到达的最远
            }
        }
        return step;
    }

    public static void main(String[] args) {
        int[] array = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};  //7,0,9,6,9,6,1,7,9,0,1,2,9,0,3
        System.out.println(new L45().jump1(array));

    }
}

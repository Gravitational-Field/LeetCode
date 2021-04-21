package leetcode;

/**
 * @ClassName L33
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/4/21 9:40
 * @Version 1.0
 **/
public class L33 {

    //思路：半有序 => 有序 => 二分查找
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length-1;
        //判断target所在的区域
        while (left < right) {
            int mid = left + (right-left)/2;

            if(target == nums[mid]) {
                return mid;
            }

            //在左侧
            if(target > nums[0]) {
                left = 0;
                right =
            }

            //在右侧
            if(target < nums[0]) {

            }



        }

    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(new L33().search(nums, target));
    }
}

package jianzhioffer;

import java.util.ArrayList;

/**
 * @ClassName Array_3_shuzuzhongchongfudeshuzi
 * @Description
 */
public class Array_3_shuzuzhongchongfudeshuzi {

    public static boolean duplicate(int nums[],int length,int [] duplication) {
        if (nums == null || length<=1) return false;
        //找出第一个重复的数字，重复数字填到duplication数组中
        for (int i = 0; i < length; i++) {
            //遍历一遍
            while(nums[i] != i) {

                if(nums[i] == nums[nums[i]]) {
                    //找到了重复
                    duplication[0] = nums[i];
                    return true;
                }
                //不重复，需要进行交换
                swap(nums, i, nums[i]);  //交换的时候传递的是它们各自的下标
            }
        }

        //没有
        return false;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int [] numbers = {2,3,1,0,2,5,3};
        int [] duplication = new int[1];
        System.out.println(duplicate(numbers, numbers.length, duplication));
    }

}

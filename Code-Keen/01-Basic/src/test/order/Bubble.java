package test.order;

/**
 * @ClassName Bubble
 * @Description
 */
public class Bubble<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        if (nums == null || nums.length == 0) return;

        int len = nums.length;
        /*for (int i = 0; i < len; i++) { //每轮要冒一个最大的上去
            //进行对比及大的冒上去
            for (int j = 0; j < len-i-1; j++) {  //最普通的类型
                if (less(nums[j+1], nums[j])) {
                    swap(nums,j+1,j);
                }
            }
        }*/
        boolean flag = false;
        for (int i = 0; i < len; i++) { //每轮要冒一个最大的上去
            flag = true; //未进行转换
            //进行对比及大的冒上去
            for (int j = 0; j < len-i-1; j++) {  //最普通的类型
                if (less(nums[j+1], nums[j])) {
                    flag = false; //排序了,发生了转换
                    swap(nums,j+1,j);
                }
            }
            if (flag) break;  //如果仍旧为true，说明没有在if语句中发生转换，故可知已经排好序了，直接退出即可
        }



    }
}

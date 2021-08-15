package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @ClassName L215
 * @Description: 数组中的第K个最大元素
 * @Author Keen
 * @DATE 2021/8/10 16:08
 * @Version 1.0
 **/
public class L215 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(); //小顶堆
        //堆中始终存储的是到当前为止最大的K个值
        for (int i = 0; i < nums.length; i++) {
            heap.offer(nums[i]);
            if(heap.size()>k) {
                heap.poll();
                //始终会将堆顶的那个值给移除，堆顶是这K个数中最小的，所以，最终遍历一遍会导致堆中的值为最大的K个，且堆顶为第K个最大的值
            }
        }
        return heap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 2;
        System.out.println(new L215().findKthLargest(nums, k));
    }

}

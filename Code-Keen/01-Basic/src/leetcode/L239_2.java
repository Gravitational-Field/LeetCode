package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName L239_1
 * @Description 单调队列解法
 */
public class L239_2 {

    //构建单调栈
    public class MonotonicQueue {
        LinkedList<Integer> q = new LinkedList<>();

        public void push(int n) { //当一个较大值过来，形成对前边小的值的压制，从而再后续无法发挥作用
            while (!q.isEmpty() && q.getLast()<n) {
                //比n小的都被踢出
                q.pollLast();
            }
            q.offerLast(n); //尾插
        }

        public Integer max() {  //队列的第一个为最大值
            return q.getFirst();
        }

        public void pop(int n) { //可能n已经被压制的踢出了
            if (n == q.getFirst()) {
                q.pollFirst();
            }
        }
    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k==0) return nums;
        MonotonicQueue mq = new MonotonicQueue();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            //整个数组过一遍
            if(i < k-1) {
                //填满前两个
                mq.push(nums[i]);
            }else {
                mq.push(nums[i]);
                list.add(mq.max());
                mq.pop(nums[i-k+1]);
            }
        }

        int[] result = new int[nums.length-k+1];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }





    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(new L239_2().maxSlidingWindow(nums, k)));
    }
}

package leetcode;

import java.util.*;

/**
 * @ClassName L239_1
 * @Description 优先级队列解法
 */
public class L239_3 {

    //构建单调栈
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        // 1. 优先队列存放的是二元组(num,index) : 大顶堆（元素大小不同按元素大小排列，元素大小相同按下标进行排列）
        // num :   是为了比较元素大小
        // index : 是为了判断窗口的大小是否超出范围
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] pair1,int[] pair2){
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0]:pair2[1] - pair1[1];
            }
        });

        // 2. 优选队列初始化 : k个元素的堆
        for(int i = 0;i < k;i++){
            pq.offer(new int[]{nums[i],i});
        }

        // 3. 处理堆逻辑
        int[] res = new int[n - k + 1];         // 初始化结果数组长度 ：一共有 n - k + 1个窗口
        res[0] = pq.peek()[0];                  // 初始化res[0] ： 拿出目前堆顶的元素
        for(int i = k; i < n; i++){               // 向右移动滑动窗口
            pq.offer(new int[]{nums[i],i});     // 加入大顶堆中
            while(pq.peek()[1] <= i - k){       // 将下标不在滑动窗口中的元素都干掉
                pq.poll();                      // 维护：堆的大小就是滑动窗口的大小
            }
            res[i - k + 1] = pq.peek()[0];      // 此时堆顶元素就是滑动窗口的最大值
        }
        return res;
    }





    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(new L239_3().maxSlidingWindow(nums, k)));
    }
}

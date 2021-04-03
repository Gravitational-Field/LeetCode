package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName L169
 * @Description: 多数元素， 找众数
 * @Author Keen
 * @DATE 2021/4/2 18:36
 * @Version 1.0
 **/
public class L169 {

    //api方式
    /*public int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        Arrays.sort(nums);
        return nums[nums.length/2];
    }*/

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        Map<Integer,Integer> map = new HashMap<>();
        int maxKey = Integer.MIN_VALUE;
        int maxCount = Integer.MIN_VALUE;

        //遍历，存储至map中
        for (int num: nums) {
            if(!map.containsKey(num)) {
                map.put(num, 1);
                if (maxKey == Integer.MIN_VALUE) {
                    maxKey = num;
                }
            } else {
                map.put(num, map.get(num)+1);
                maxCount = Math.max(maxCount, map.get(num));
                if(maxCount == map.get(num)) {
                    //更新maxKey
                    maxKey = num;
                }
            }
        }
        return maxKey;
    }



    public static void main(String[] args) {
        int[] array = {1};

        System.out.println(new L169().majorityElement(array));
    }
}

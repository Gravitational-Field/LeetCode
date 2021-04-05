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

    //2. hash存储并计数
    /*public int majorityElement(int[] nums) {
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
    }*/


    //3. 分治思想
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return getMajor(nums, 0, nums.length-1);
    }

    private int getMajor(int[] nums, int low, int high) {
        if(low == high) {
            return nums[low];
        }

        int mid = (high-low)/2+low;
        int leftMajor = getMajor(nums, low, mid);
        int rightMajor = getMajor(nums, mid+1, high);

        //得到左边众数和右边众数
        if(leftMajor == rightMajor) {
            return leftMajor;
        }
        //左右众数不同
        int leftCount = inRangeCount(nums, low, mid, leftMajor);
        int rightCount = inRangeCount(nums, mid+1, high, rightMajor);

        return leftCount>rightCount?leftMajor:rightMajor;
    }

    private int inRangeCount(int[] nums, int i1, int i2, int major) {
        int count = 0;
        for (int i = i1; i <= i2; i++) {
            if(nums[i] == major) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] array = {1,2,2,2,3};

        System.out.println(new L169().majorityElement(array));
    }
}

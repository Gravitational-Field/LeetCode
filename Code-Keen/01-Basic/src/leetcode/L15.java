package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @ClassName L15
 * @Description: 三数之和
 * @Author Keen
 * @DATE 2021/7/16 21:19
 * @Version 1.0
 **/
public class L15 {
    public List<List<Integer>> threeSum(int[] nums) {
        //注意：答案中不可以包含重复的三元组。需要排序处理
        //非返回索引，可以排序
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return lists;
        }
        Arrays.sort(nums);

        //法1：暴力求解
        HashSet<List<Integer>> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        hashSet.add(list);
                    }
                }
            }
        }
        for (List<Integer> list : hashSet) {
            lists.add(list);
        }
        //法2：三指针
        for (int i = 0; i < nums.length; i++) {
            //判断首位，首位大于0，则没有满足的
            if (nums[i] > 0) {
                break;
            }
            //
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R) {
                //进行判断
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    lists.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    //分别去重
                    while (L < R && nums[L] == nums[L + 1]) L++;
                    while (R > L && nums[R] == nums[R - 1]) R--;
                    //去重之后，再移一位
                    L++;
                    R--;
                } else if (sum < 0) {
                    L++;
                } else if (sum > 0) {
                    R--;
                }
            }
        }
        return lists;
    }
}

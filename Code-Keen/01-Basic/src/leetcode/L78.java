package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName L78
 * @Description: 子集: 全部集合
 * @Author Keen
 * @DATE 2021/4/1 13:09
 * @Version 1.0
 **/
public class L78 {

    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> deque = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) return res;

        dfs(nums,0);
        return res;
    }

    private void dfs(int[] nums, int index) {
        if(index == nums.length) {
            res.add(new ArrayList<>(deque));
            return;
        }
        //考虑选择当前位置
        deque.push(nums[index]);
        dfs(nums, index+1);
        deque.pop(); //回退一步，考虑不选择当前位置
        dfs(nums, index+1);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        L78 l78 = new L78();
        l78.subsets(nums);
        System.out.println(l78.res);
    }
}

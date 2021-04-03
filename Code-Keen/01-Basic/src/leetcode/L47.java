package leetcode;

import java.util.*;

/**
 * @ClassName L47 全排列2
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/3/27 16:52
 * @Version 1.0
 **/
public class L47 {

    Deque<Integer> deque = new ArrayDeque<>();
    List<List<Integer>> res = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null || nums.length == 0) {
            return res;
        }
        used = new boolean[nums.length];
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int depth) {
        if(deque.size() == nums.length) {
            ArrayList<Integer> tmpList = new ArrayList<>(deque);
            //去重
            boolean flag = false;
            for (int i = 0; i < res.size(); i++) {
                if(Arrays.equals(res.get(i).toArray(),tmpList.toArray())) {
                    flag = true;
                    break;
                }
            }
            if(!flag) { //没有重复的
                System.out.println(tmpList);
                res.add(tmpList);
            }
            //System.out.println(new ArrayList<>(deque).toString());
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(used[i]) {
                continue;
            }
            deque.push(nums[i]);
            used[i] = true;
            dfs(nums, depth+1);
            used[i] = false;
            deque.pop();
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,1};
        List<List<Integer>> permute = new L47().permuteUnique(array);
        System.out.println(permute);
    }
}

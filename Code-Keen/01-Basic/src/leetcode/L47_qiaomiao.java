package leetcode;

import java.util.*;

/**
 * @ClassName L47 全排列2
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/3/27 16:52
 * @Version 1.0
 **/
public class L47_qiaomiao {

    Deque<Integer> deque = new ArrayDeque<>();
    List<List<Integer>> res = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null || nums.length == 0) {
            return res;
        }
        used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int depth) {
        if(deque.size() == nums.length) {
           res.add(new ArrayList<>(deque));
            //System.out.println(new ArrayList<>(deque).toString());
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(used[i]) {
                continue;
            }

            if(i>0 && nums[i] == nums[i-1] && used[i-1]==false) { //刚才那个已经被释放，则跳过，应为与前者相同
                continue;
            }
            //used[i-1] 正在被用时，可以不用不用考虑前者，因为顺序不同
            deque.push(nums[i]);
            used[i] = true;
            dfs(nums, depth+1);
            used[i] = false;
            deque.pop();
        }
    }

    public static void main(String[] args) {
        int[] array = {3,3,0,3};
        List<List<Integer>> permute = new L47_qiaomiao().permuteUnique(array);
        System.out.println(permute);
    }
}

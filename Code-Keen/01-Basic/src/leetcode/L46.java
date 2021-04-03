package leetcode;

import sun.applet.AppletResourceLoader;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName L46 全排列
 * @Description: 多叉树的DFS
 * @Author Keen
 * @DATE 2021/3/27 15:50
 * @Version 1.0
 **/
public class L46 {

    Deque<Integer> deque = new ArrayDeque<>();
    List<List<Integer>> res = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0) {
            return res;
        }
        used = new boolean[nums.length];
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
            if(used[i]) { //避免重复使用在一个序列中
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
        int[] array = {1,2,3};
        List<List<Integer>> permute = new L46().permute(array);
        System.out.println(permute);
    }
}

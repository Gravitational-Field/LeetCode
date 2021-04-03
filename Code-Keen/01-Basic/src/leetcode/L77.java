package leetcode;

import java.util.*;

/**
 * @ClassName L77
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/3/23 15:13
 * @Version 1.0
 **/
public class L77 {

    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> deque = new ArrayDeque<>();

    public List<List<Integer>> combine(int n, int k) {
        if(n < k || k <= 0) {
            return res;
        }
        dfs(n, k, 1);
        return res;
    }

    //回溯法进行递归
    private void dfs(int n, int k, int start) { //每次获得一位
        if(deque.size() == k) {
            res.add(new ArrayList<>(deque));  //这步不错
            return;
        }

        for (int i = start; i <= n; i++) {
            deque.push(i);
            dfs(n, k, i+1);
            deque.pop();
        }
    }



}

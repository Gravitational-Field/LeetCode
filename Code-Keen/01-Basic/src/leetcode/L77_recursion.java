package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName L77
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/3/23 15:13
 * @Version 1.0
 **/
public class L77_recursion {

    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> deque = new ArrayDeque<>();

    public List<List<Integer>> combine(int n, int k) {
        if(n < k || k <= 0) {
            return res;
        }
        build(n, k, 1);
        return res;
    }

    //递归
    private void build(int n, int k, int start) { //每次获得一位
        if(k == 0) {
            res.add(new ArrayList<>(deque));  //这步不错
            return;
        }
        //结束条件
        if(start > n-k+1) {
            return;
        }

        //不选这位,直接递归到后续
        build(n, k, start+1);

        //选择这位
        deque.push(start);
        build(n, k-1, start+1);
        deque.pop();

    }

    

}

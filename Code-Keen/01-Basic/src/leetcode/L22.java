package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName L22
 * @Description
 */
public class L22 {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        String path = "";
        //穷举DFS
        dfs(n,list, path, 0, 0);
        return list;
    }

    private void dfs(int n, List<String> list, String path, Integer open, Integer close) {
//        if (open > n || close > open) return;   //进行剪枝，还有另一种方式
        //根  左   右
        if(path.length() == 2*n) {
            list.add(path);
            return;
        }
        //左
        if (open < n) { //才会向左访问
            dfs(n, list, path + "(", open + 1, close);
        }
        //右
        if(close < open) { //才会向右访问
            dfs(n, list, path + ")", open, close + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new L22().generateParenthesis(2));
    }

}

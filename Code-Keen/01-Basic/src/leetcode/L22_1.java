package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName L22_1
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/5/11 20:33
 * @Version 1.0
 **/
public class L22_1 {

    List<String> resultList = new ArrayList<>();
    int n;
    public List<String> generateParenthesis(int n) {
        this.n = n;
        if(n <= 0) {
            return resultList;
        }
        int level = 1;
        dfs("", 0, 0);

        return resultList;
    }


    private void dfs(String str, int open, int close) {
        //结束条件
        if(str.length() == 2*n) {
            resultList.add(str);
            return;
        }

        //左
        if(open < n) {
            //放(
            dfs(str+"(",open+1, close);
        }

        //右
        if(open > close) {
            //放)
            dfs(str+")",open, close+1);
        }
    }


    public static void main(String[] args) {
        System.out.println(new L22_1().generateParenthesis(3));
    }
}

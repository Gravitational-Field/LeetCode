package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName L51
 * @Description: N皇后
 * @Author Keen
 * @DATE 2021/4/6 9:05
 * @Version 1.0
 **/
public class L51 {

    List<List<String>> resList = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        if(n<=0) {
            return resList;
        }

        build(new ArrayList<>(), 0, n);
        return resList;
    }

    //每次构建一个list的item
    private void build(ArrayList<String> list, int row, int n) {
        if(row == n) {
            //构建完成
            resList.add(new ArrayList<>(list));
            return;
        }

        //构建一个
        for (int i = 0; i < n; i++) { //控制column
            if(isVaild(list, row, i, n)) {
                //生成该行的字符串
                list.add(generateString(i, n));
                build(list, row+1,n);
                list.remove(list.size()-1);
            }
        }
    }

    //根据行与列判断是否合法                                行    当前列索引  最后的限制处
    private boolean isVaild(ArrayList<String> list, int row, int index, int n) {
        //判断当前索引位置是否合规
        //判断列是否合法
        for (int j = 0; j < list.size(); j++) { //j代表第j个字符串
            if(list.get(j).charAt(index) == 'Q') {  //不能在同一列上
                return false;
            }

            //判断右侧合法性
            if(row - index == j-list.get(j).indexOf('Q')) { //不能在右斜线上
                return false;
            }

            //判断左侧合法性
            if(row + index == j+list.get(j).indexOf('Q')) {  //不能在左侧斜线上
                return false;
            }
        }
        return true;
    }

    //生成每行的字符串
    private String generateString(int column, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if(i == column) {
                sb.append('Q');
            } else {
                sb.append('.');
            }
        }
        return sb.toString();
    }
}

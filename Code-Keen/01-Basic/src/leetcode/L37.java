package leetcode;

import java.util.Arrays;

/**
 * @ClassName L37
 * @Description: 
 * @Author Keen
 * @DATE 2021/5/20 20:04
 * @Version 1.0
 **/
public class L37 {

    private int num = 0;
    public void solveSudoku(char[][] board) {
        //回溯法
        backtrack(board, 0, 0);
    }

    //回溯方法
    private boolean backtrack(char[][] board, int r, int c) {
        num++;
        //结束条件
        if(c == 9) {
            //重新定位，进行回溯
            return backtrack(board, r+1, 0);
        }

        if(r == 9) {
            //增加到了最后一行
            return true;
        }

        for (int i = r; i < 9; i++) {
            for (int j = c; j < 9; j++) {
                if(board[i][j] != '.') {
                    //不进行操作,继续进行下一个位置
                    return backtrack(board, i, j+1);
                }

                //遍历操作
                for (char ch = '1'; ch <= '9'; ch++) {
                    if(!isValid(board, i, j, ch)) {
                        continue;
                    }
                    
                    //插入之前需要进行验证，插入是否合法,此时已经是合法的了
                    board[i][j] = ch;
                    if(backtrack(board, i, j+1)) {
                        return true;
                    }
                    board[i][j] = '.';
                }
                return false;
            }
        }
        return false;
    }

    boolean isValid(char[][] board, int r, int c, char ch) {

        for (int i = 0; i < 9; i++) {
            //判断行是否有效
            if(board[i][c] == ch) return false;
            //判断列是否有效
            if(board[r][i] == ch) return false;
            //判断单个box中是否有效
            if(board[(r/3)*3 + i/3][(c/3)*3 + i%3] == ch) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        L37 l37 = new L37();
        l37.solveSudoku(board);

        System.out.println(l37.num);
        for (char[] array:board) {
            System.out.println(Arrays.toString(array));
        }
        //System.out.println(Arrays.toString(board));

    }

}

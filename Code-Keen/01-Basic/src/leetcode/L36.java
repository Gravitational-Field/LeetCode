package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName L36
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/5/14 10:05
 * @Version 1.0
 **/
public class L36 {


    public boolean isValidSudoku(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxs = new boolean[9][9];
        for (int i = 0; i < row; i++) { //双重循环解决：遍历一遍
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '1';
                int boxIndex = (i / 3) * 3 + j / 3;  //计算是第几个box
                if (rows[i][num]) return false;
                else rows[i][num] = true;
                if (cols[j][num]) return false;
                else cols[j][num] = true;
                if (boxs[boxIndex][num]) return false;
                else boxs[boxIndex][num] = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] border = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                           {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                           {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                           {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                           {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                           {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                           {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                           {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                           {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println(new L36().isValidSudoku(border));
    }
}

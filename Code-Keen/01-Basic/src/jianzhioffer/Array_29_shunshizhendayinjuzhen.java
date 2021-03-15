package jianzhioffer;

import java.util.ArrayList;

/**
 * @ClassName Array_29_shunshizhendayinjuzhen
 * @Description
 */
public class Array_29_shunshizhendayinjuzhen {

    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        //判断合法性
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return null;
        //创建存储的ArrayList
        ArrayList<Integer> array = new ArrayList<>();
        //确定边界
        int up = matrix[0].length-1;
        int right = matrix.length-1;
        int down = 0;
        int left = 0;

        //while循环走一圈
        while (up>down && right>left) {
            //内部轮一圈
            //上
            for (int i = left; i < up; i++) {
                array.add(matrix[left][i]);
            }
            //右
            for (int i = down; i < right; i++) {
                array.add(matrix[i][up]);
            }
            //下
            for (int i = right; i > down; i--) {
                array.add(matrix[right][i]);
            }
            //左
            for (int i = right; i > left; i--) {
                array.add(matrix[i][down]);
            }
            //更新
            up--;
            right--;
            down++;
            left++;
        }
        return array;
    }

    public static void main(String[] args) {
//        int [][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int [][] matrix = {{1}};

        ArrayList<Integer> al = printMatrix(matrix);
        al.forEach(System.out::print);
    }
}

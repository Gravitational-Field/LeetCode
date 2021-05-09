package leetcode;

/**
 * @ClassName L74
 * @Description
 */
public class L74 {
    //暴力查找
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (target == matrix[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    //二分查找： 先确定target处于哪一行 =》 对那一行进行二分查找
    public boolean searchMatrix1(int[][] matrix, int target) {
        //for循环确定所处行
        int i;
        //每行的长度
        int rowLength = matrix[0].length;
        for (i = 0; i < matrix.length; i++) {
            if ((matrix[i][rowLength-1] == target)) {
                return true;
            }
            if ((matrix[i][rowLength-1] > target)) {
                break;
            }
        }
        i = i%matrix.length; //防止越界
        System.out.println(i);
        int left = 0,right = rowLength-1;

        int mid = Integer.MIN_VALUE;
        while (left <= right) {
            mid = left + (right-left)/2;

            if (matrix[i][mid] == target) {
                return true;
            } else if (matrix[i][mid] > target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return matrix[i][mid] == target;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int[][] matrix = {{1}};
        int target = 2;
        System.out.println(new L74().searchMatrix1(matrix, target));
    }
}

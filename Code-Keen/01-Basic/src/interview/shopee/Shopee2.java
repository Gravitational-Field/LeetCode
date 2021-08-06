package interview.shopee;

import java.util.Arrays;

/**
 * @ClassName Shopee2
 * @Description: 杨辉三角
 * @Author Keen
 * @DATE 2021/7/19 16:22
 * @Version 1.0
 **/
public class Shopee2 {

    public int getValue(int rowIndex, int columnIndex) {
        if(rowIndex<=0 || columnIndex <= 0) {
            return -1;
        }
        int[][] nums = new int[rowIndex][rowIndex];

        for (int i = 0; i < rowIndex; i++) {
            for (int j = 0; j <= i; j++) {
                if(j == 0 || j==rowIndex-1) {
                    nums[i][j] = 1;
                } else {
                    nums[i][j] = nums[i - 1][j - 1] + nums[i - 1][j];
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                System.out.print(nums[i][j]+" ");
            }
            System.out.println();
        }

        return nums[rowIndex-1][columnIndex-1];
    }

    public static void main(String[] args) {
        System.out.println(new Shopee2().getValue(4,3));
    }

}

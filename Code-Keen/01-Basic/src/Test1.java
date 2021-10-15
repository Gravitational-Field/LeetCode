import java.util.Arrays;

/**
 * @ClassName Test1
 * @Description
 */
public class Test1{

    public static void main(String[] args) {
        int n = 3;
        int [][] arr = getMatrix(n);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }


    }

    private static int[][] getMatrix(int n) {
        int maxNum = n*n;
        int curNum = 1;
        int[][] arr = new int[n][n];

        int row = 0;
        int col = 0;

        int[][] directions = {{0, 1},{1,0},{0,-1},{-1,0}}; //右 下 左  上

        int dirIndex = 0; //初始方向

        while(curNum<=maxNum) {
            arr[row][col] = curNum;
            curNum++;
            int nextRow = row + directions[dirIndex][0];
            int nextCol = col + directions[dirIndex][1];
            //限制
            if (nextRow < 0 || nextRow >= n || nextCol<0 || nextCol>=n || arr[nextRow][nextCol] != 0) {
                //更新方向
                dirIndex = (dirIndex+1)%4;
            }
            row = row+directions[dirIndex][0];
            col = col+directions[dirIndex][1];
        }
        return arr;
    }

}

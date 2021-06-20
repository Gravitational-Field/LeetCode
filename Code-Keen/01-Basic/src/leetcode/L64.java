package leetcode;

/**
 * @ClassName L64
 * @Description
 */
public class L64 {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int row = grid.length;
        int col = grid[0].length;
        String str = "";
        str.toCharArray();


        return 0;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(new L64().minPathSum(grid));
    }
}

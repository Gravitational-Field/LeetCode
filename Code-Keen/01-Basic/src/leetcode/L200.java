package leetcode;

import com.sun.javafx.logging.JFRInputEvent;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName L200
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/5/7 10:04
 * @Version 1.0
 **/
public class L200 {

    //定义
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 右、下两个方向
    int count = 0;
    boolean[][] visited;
    int row;
    int col;

    //1. dfs方式
    public int numIslands(char[][] grid) {
        //判空
        if (grid == null) {
            return 0;
        }
        row = grid.length;
        if (row == 0) {
            return 0;
        }
        col = grid[0].length;
        visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j);  //进行一次dfs，即代表一座岛屿
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        //结束条件
        if (grid[i][j] == '0' && !visited[i][j]) {
            visited[i][j] = true;
            return;
        }

        //根
        visited[i][j] = true;

        //多叉
        for (int[] direction : directions) {
            int newX = i + direction[0];
            int newY = j + direction[1];
            if (newX >= 0 && newX < row && newY >= 0 && newY < col && !visited[newX][newY]) {
                dfs(grid, newX, newY);
            }
        }
    }


    //2. bfs方式
    public int numIslandsBFS(char[][] grid) {
        //判空
        if (grid == null) {
            return 0;
        }
        row = grid.length;
        if (row == 0) {
            return 0;
        }
        col = grid[0].length;
        visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    bfs(grid, i, j);  //进行一次dfs，即代表一座岛屿
                    count++;
                }
            }
        }
        return count;
    }

    //迭代的方式

    private void bfs(char[][] grid, int i, int j) {
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(i * col + j); //该编码必须在队列中唯一
        visited[i][j] = true;

        while (!deque.isEmpty()) {
            Integer first = deque.removeFirst(); // deque.poll()
            int curX = first / col;
            int curY = first % col;

            //多叉
            for (int[] direction : directions) {
                int newX = curX + direction[0];
                int newY = curY + direction[1];
                if (newX >= 0 && newX < row && newY >= 0 && newY < col && !visited[newX][newY] && grid[newX][newY] == '1') {
                    deque.addLast(newX * col + newY);  // deque.offer()
                    visited[newX][newY] = true;
                }
            }
        }
    }


    //3. 并查集
    public int numIslandsUnionFind(char[][] grid) {
        //判空
        if (grid == null) {
            return 0;
        }
        row = grid.length;
        if (row == 0) {
            return 0;
        }
        col = grid[0].length;
        UnionFind unionFind = new UnionFind(row * col);
        int spaces = 0; //记录0出现的次数，每个0相当于一个单独的连通分量

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '0') {
                    spaces++;
                } else {
                    for (int[] direction : directions) {
                        int newX = i + direction[0];
                        int newY = j + direction[1];
                        if (newX >= 0 && newX < row && newY >= 0 && newY < col && grid[newX][newY] == '1') {
                            unionFind.union(i*col+j, newX*col+newY);
                        }
                    }
                }
            }
        }
        return unionFind.count-spaces;
    }


    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        char[][] grid1 = {{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}};

        char[][] grid2 = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};

        char[][] grid3 = {{'1'}, {'1'}};
        System.out.println(new L200().numIslandsUnionFind(grid));
        System.out.println(new L200().numIslandsUnionFind(grid1));
        System.out.println(new L200().numIslandsUnionFind(grid2));
        System.out.println(new L200().numIslandsUnionFind(grid3));
    }

}

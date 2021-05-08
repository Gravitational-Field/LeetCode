package interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    //
    //Map<String, Set<Integer>> map = new HashMap<>();

    Set<Integer> set = new HashSet<>();

    int row;
    int col;
    int[][] grid;
    int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    //递归思路：dfs
    int getMaxDifferent(int[][] grid) {
        this.grid = grid;
        row = grid.length;
        col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                dfs(i,j,Integer.toString(grid[i][j]),1);
            }
        }
        return set.size();
    }

    //采用回溯的方式
    private void dfs(int i, int j, String str,int level) { //level指示第几层，起始是第一层
        if(level == 6) {
            //set.add
            set.add(Integer.valueOf(str));
            return;
        }
        //根
        //str += grid[i][j];

        for (int[] direction:directions) {
            int newX = i+direction[0];
            int newY = j+direction[1];
            //判断不越界
            if(newX >= 0 && newX < row && newY >= 0 && newY < col) {
                dfs(newX,newY,str+grid[newX][newY],level+1);
            }
        }
    }


    public static void main(String[] args) {
        /*int[][] grid = {{1,1,1,1,1},
                        {1,1,1,1,1},
                        {1,1,1,1,1},
                        {1,1,1,1,1},
                        {2,1,1,1,1}};

        Main renyizuhe = new Main();
        System.out.println(renyizuhe.getMaxDifferent(grid));
        System.out.println(renyizuhe.set.toString());*/


        int[][] grid = new int[1000][0];
        //grid = new int[][];
        //int[] b = new int[0];
        Scanner in = new Scanner(System.in);
        int j = 0;
        while (in.hasNextLine()) {
            String s = in.nextLine();
            String[] s1 = s.split(" ");
            int[] b = new int[s1.length];
            for (int i = 0; i < b.length; i++) {
                b[i] = Integer.valueOf(s1[i]);
            }
            //System.out.println(Arrays.toString(b));
            grid[j++] = b;
            System.out.println(Arrays.toString(grid[j-1]));
        }

       /* while (in.hasNextInt()) { //注意while处理多个case  int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }*/
        //System.out.println(b.toString());


    }
}

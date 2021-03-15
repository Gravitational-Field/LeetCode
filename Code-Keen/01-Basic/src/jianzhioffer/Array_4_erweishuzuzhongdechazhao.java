package jianzhioffer;

/**
 * @ClassName Array_4_erweishuzuzhongdechazhao
 * @Description
 */
public class Array_4_erweishuzuzhongdechazhao {

    public static boolean Find(int target, int [][] array) {
        if (array == null || array.length==0 || array[0].length == 0) return false;
        //思路从右上开始，比其大的在它下边，比其小的在其左侧
        int row = 0;
        int col = array[0].length-1;

        while (row <= array.length-1 && col >= 0 ) {
            if (target == array[row][col]) {
                return true;
            }else if (target > array[row][col]) {
                //向下移动
                row++;
            }else {
                //比当前的小，向左移动
                col--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(Find(5,array));
    }
}

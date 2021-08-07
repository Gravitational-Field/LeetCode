package test;

import java.util.Arrays;

/**
 * @ClassName TestArray
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/7/28 10:48
 * @Version 1.0
 **/
public class TestArray {


    public int getCount(int[] arr) {
        int[] newArr = new int[arr.length+2];
        arr = newArr;
        arr[0] = 11;
        System.out.println(Arrays.toString(arr));  //[11, 0, 0, 0, 0, 0, 0]
        return 1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        TestArray testArray = new TestArray();
        testArray.getCount(arr);
        System.out.println(Arrays.toString(arr)); // [1, 2, 3, 4, 5]
    }
}

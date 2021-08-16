package interview.baidu;

import java.util.Arrays;

/**
 * @ClassName Test2
 * @Description 数对之差
 */
public class Test2 {

    public int getResult(int[] arr) {
        int[] results = new int[arr.length];
        Arrays.fill(results,Integer.MIN_VALUE);
        for (int i = 0; i < results.length; i++) {
            for (int j = i; j < arr.length; j++) {
                results[i] = Math.max(results[i],arr[i]-arr[j]);
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < results.length; i++) {
            max = Math.max(max,results[i]);
        }

        return max;
    }


    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 16, 7, 5, 11, 9};
        System.out.println(new Test2().getResult(arr));
    }

}

package niuke;

import javafx.scene.layout.Priority;

import java.util.*;

/**
 * @ClassName NC119
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/7/13 19:17
 * @Version 1.0
 **/
public class NC119 {

    //得到前K个值
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList(k);
        Arrays.sort(input);
        for (int num: input) {
            System.out.print(num+" ");
        }

        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] input = {4,5,1,6,2,7,3,8};
        int k = 4;
        System.out.println(new NC119().GetLeastNumbers_Solution(input, k).toString());
        //Thread
    }
}

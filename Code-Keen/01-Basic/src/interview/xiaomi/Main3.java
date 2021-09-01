package interview.xiaomi;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @ClassName Main2
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/9/1 19:54
 * @Version 1.0
 **/
public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxSize = sc.nextInt();
        int M = 3;
        int[] a = new int[maxSize];
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < maxSize; i++) {
            a[i] = i+1;
            list.add(i+1);
        }

        //System.out.println(Arrays.toString(a));
        int j = 0;
        int i = 0;
        //boolean flag = true;
        int size = a.length;

        for (int k = 0; k < a.length-1; k++) {
            //总共删除k次
            //list.remo

        }

        while (true) {
            if(size == 1) {
                System.out.println(list.getFirst());;
            } else {

            }

        }





        //System.out.println(i+1);
    }
}

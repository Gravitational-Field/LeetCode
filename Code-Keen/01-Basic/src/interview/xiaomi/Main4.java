package interview.xiaomi;

import java.util.Scanner;

/**
 * @ClassName Main2
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/9/1 19:54
 * @Version 1.0
 **/
public class Main4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = 3;
        boolean[] arr = new boolean[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = true;
        }

        int leftCount = arr.length;
        int countNum = 0;
        int index = 0;

        while(leftCount >1) {
            if(arr[index] == true) {
                countNum++;
                if(countNum == M) {
                    countNum = 0;
                    arr[index] = false;
                    leftCount--;
                }

            }
            index++;
            if(index == arr.length) {
                index = 0;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == true) {
                System.out.println(i+1);
            }
        }
    }
}

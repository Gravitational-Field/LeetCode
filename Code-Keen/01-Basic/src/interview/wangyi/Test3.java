package interview.wangyi;

import java.util.Scanner;

/**
 * @ClassName Test3
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/8/21 15:49
 * @Version 1.0
 **/
public class Test3 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        int[] arr = new int[s1.length];
        for (int i = 0; i < s1.length; i++) {
            arr[i] = Integer.parseInt(s1[i]);
        }

        int len = arr.length;
        int[] left = new int[len];
        for (int i = 0; i < 2*len; i++) {
            if(i>0&&arr[i%len] > arr[(i-1)%len]) {
                left[i%len] = left[(i-1)%len]+1;
            } else {
                left[i%len] = 1;
            }
        }

        int right = 0;
        int ret = 0;
        for (int i = 2*len-1; i >= 0 ; i--) {
            if(i<2*len-1 && arr[i%len] > arr[(i+1)%len]) {
                right++;
            }else {
                right = 1;
            }
            ret += Math.max(left[i%len],right);
        }
        System.out.println(ret/2);

    }
}

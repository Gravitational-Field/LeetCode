package interview.tx;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Test1
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/8/22 19:49
 * @Version 1.0
 **/
public class Test2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = Integer.valueOf(sc.nextLine());
        final int MOD = 1000000007;
        for(int i = 0; i < count; i++){
            int n = Integer.valueOf(sc.nextLine());

            String[] strings = sc.nextLine().split(" ");
            int[] arr = new int[n];

            for (int j = 0; j < strings.length; j++) {
                arr[j] = Integer.valueOf(strings[j]);
            }

            Arrays.sort(arr);
            int sum = 0;
            //System.out.println(Arrays.toString(arr));
            for (int k = arr.length - 1; k >= 0; k--) {
                //sum += arr[k]%1000000007;
                sum = (sum + arr[k])%MOD;
                //更新数据
                for (int l = 0; l < k; l++) {
                    arr[l] = (arr[l]+arr[k])%MOD;
                }
            }
            System.out.println(sum);
        }
    }
}

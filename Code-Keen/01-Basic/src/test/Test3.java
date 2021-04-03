package test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Test3
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/3/22 19:34
 * @Version 1.0
 **/
public class Test3 {

    public static int[] array;

    public static int change(int amount, int[] coins) {
        if (coins == null) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(n+" "+m);
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        //System.out.println(Arrays.toString(array));

        int flag = change(m, array);
        if(flag == 0) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}

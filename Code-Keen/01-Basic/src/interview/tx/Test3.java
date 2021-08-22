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
public class Test3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.valueOf(sc.nextLine());
        for (int i = 0; i < num; i++) {
            String[] string1 = sc.nextLine().split(" ");
            String[] string2 = sc.nextLine().split(" ");

            int n = Integer.valueOf(string1[0]);
            int max = Integer.valueOf(string1[1]);
            int[] weight = new int[n];
            int[] temp = new int[n];

            for (int j = 0; j < n; j++) {
                weight[j] = Integer.valueOf(string2[j]);
            }

            Arrays.sort(weight);

            int ans = 0;
            for (int j = n-1; j >= 0; j--) {
                if(temp[j] == 0) {
                    for (int k = j-1; k >=0 ; k--) {
                        if(temp[k] ==0 && (weight[j]+weight[k])%2 == 0 && (weight[j]+weight[k])<=max) {
                            temp[j] = 1;
                            temp[k] = 1;
                            ans++;
                            break;
                        }
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                if(temp[j] == 0) {
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }
}

//2
//6 5
//1 2 5 4 1 2
//10 6
//1 2 2 1 3 3 2 3 1 5
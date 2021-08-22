package interview.wangyi;

import java.util.Scanner;

/**
 * @ClassName Test33
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/8/21 16:38
 * @Version 1.0
 **/
public class Test33 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        int[] num = new int[s1.length];
        for (int i = 0; i < s1.length; i++) {
            num[i] = Integer.parseInt(s1[i]);
        }

        int n = num.length;
        int ret = 1;
        int inc = 1, dec = 0, pre = 1;

        for (int i = 1; i < n - 1; i++) {
            if (num[i] >= num[i - 1] || num[i] >= num[i + 1]) {
                dec = 0;
                pre = num[i] == num[i - 1] ? 1 : pre+1;
                ret += pre;
                inc = pre;
            } else {
                dec++;
                if(dec == inc) {
                    dec++;
                }
                ret += dec;
                pre = 1;
            }
        }

        if(num[n-1] > num[n-2] || num[n-1] > num[0]) {
            pre = num[n-1] == num[n-2] ? 1: pre+1;
            ret += pre;
        } else {
            dec++;
            if(dec == inc) {
                dec++;
            }
            ret+=dec;
        }

        System.out.println(ret);

    }
}

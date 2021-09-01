package interview.xiaomi;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Main1
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/9/1 19:29
 * @Version 1.0
 **/
public class Main1 {

    public static void main(String[] args) {
        /*int[] A = {1, 6, 7, 0, 0, 0};
        int[] B = {2, 4, 6};

        System.arraycopy(B, 0, A, 3, B.length);
        System.out.println(Arrays.toString(A));*/

        Scanner sc = new Scanner(System.in);
        //m=2,n=2
        //1,3
        //2,4
        String line1 = sc.nextLine();
        //解析m,n
        //line1.split(",")
        int i1 = line1.indexOf("=");
        int i2 = line1.indexOf(",");
        int j1 = line1.lastIndexOf("=");
        //System.out.println(i1);
        //System.out.println(i2);
        //System.out.println(j1);
        int m = Integer.valueOf(line1.substring(line1.indexOf("=")+1, line1.indexOf(",")));
        int n = Integer.valueOf(line1.substring(line1.lastIndexOf("=")+1, line1.length()));

        String line2 = sc.nextLine();
        String line3 = sc.nextLine();
        String[] split1 = line2.split(",");
        String[] split2 = line3.split(",");

        //解析数组
        int[] A = new int[split1.length+ split2.length];
        int[] B = new int[split2.length];

        for (int i = 0; i < split1.length; i++) {
            A[i] = Integer.valueOf(split1[i]);
        }
        for (int i = 0; i < split2.length; i++) {
            B[i] = Integer.valueOf(split2[i]);
        }

        System.arraycopy(B, 0, A, split1.length, B.length);
        Arrays.sort(A);

        for (int i = 0; i < A.length; i++) {
            if(i == A.length-1) {
                System.out.print(A[i]);
            } else {
                System.out.print(A[i] + " ");
            }
        }

        //m=3,n=2
        //1,3
        //2,4
    }
}

package interview.xingyeshujin;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @ClassName Test1
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/8/31 19:34
 * @Version 1.0
 **/
public class Test1 {

    ArrayList<Integer> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        System.out.println(factor(num));
    }

    private static String factor(int num) {

        String res = ""+num+"=";
        for (int i = 2; i <= num ; i++) {

            if(num%i == 0) {
                num /= i;
                res = res+i+"*";
                i--; //45=3*3*5
            }
        }

        //System.out.println();

        return res.substring(0, res.length()-1);
    }
}

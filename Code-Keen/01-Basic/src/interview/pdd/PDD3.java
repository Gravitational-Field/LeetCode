package interview.pdd;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @ClassName PDD3
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/7/25 20:00
 * @Version 1.0
 **/
public class PDD3 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[10];
        for (int i = 0; i < 10; i++) {
            nums[i] = sc.nextInt();
        }

        BigInteger a = new BigInteger("0");
        BigInteger b = new BigInteger("0");

        boolean flag = true;

        for (int i = 9; i >= 0; i--) {
            while ((nums[i] > 0)) {
                if(flag) {
                    a = a.multiply(new BigInteger("10")).add(new BigInteger(""+i));
                    nums[i]--;
                    flag = false;
                }else {
                    b = b.multiply(new BigInteger("10")).add(new BigInteger(""+i));
                    nums[i]--;
                    flag = true;
                }
            }
        }
        System.out.println(a.multiply(b));
        //HashMap<Object, Object> map = new HashMap<>();
        //map.remove()
    }

}

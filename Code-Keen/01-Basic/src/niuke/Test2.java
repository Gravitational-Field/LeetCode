package niuke;

import java.util.Scanner;

/**
 * @ClassName Test2
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/7/29 19:42
 * @Version 1.0
 **/
public class Test2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            //int a2=0,b3=0,d4=0;
            long a2=0L,b3=0L,d4=0L;
            //a2 = in.nextInt();
            //b3 = in.nextInt();
            //d4 = in.nextInt();
            a2 = in.nextLong();
            b3 = in.nextLong();
            d4 = in.nextLong();

            //进行计算
            //5的个数
            long count = 2*(a2+b3+d4)+2;
            for (long i = 1; i <= count; i++) {
                double avg = 0;
                long sum = 2*a2+3*b3+4*d4+5*i;
                double countSum = a2+b3+d4+i+0.0;
                avg = sum/countSum;
                if(avg >= 3.5) {
                    System.out.println(i);
                    return;
                }
            }
        }
    }
}

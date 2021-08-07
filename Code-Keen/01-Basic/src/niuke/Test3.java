package niuke;

import java.util.Scanner;

/**
* @author: Keen
* @Description:
*/
public class Test3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n=0,m=0,k=0;
            n = in.nextInt();
            m = in.nextInt();
            k = in.nextInt();

            if(n*m < k) {
                System.out.println(-1);
                return;
            }

            return;
        }
    }
}

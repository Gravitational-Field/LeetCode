package interview.wangyi;

import java.util.Scanner;

/**
 * @ClassName Test1
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/8/21 15:15
 * @Version 1.0
 **/
public class Test1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //while (in.hasNextLine()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
        String s = in.nextLine();
        //System.out.println(s);
        String[] s1 = s.split(" ");

        int[] arr = new int[s1.length];
        for (int i = 0; i < s1.length; i++) {
            arr[i] = Integer.parseInt(s1[i]);
        }

        System.out.println("===========");
        int num = in.nextInt();

        int count = 0;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if((arr[i] + arr[j]) <= num) {
                    count++;
                }
            }
        }
        System.out.println(count);

        //7 -1 -1
    }
}

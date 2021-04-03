package niuke;

import java.io.StringBufferInputStream;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @ClassName Njuzinixu
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/3/22 20:25
 * @Version 1.0
 **/
public class Njuzinixu {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        Deque<String> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();


        while (in.hasNext()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            char[] chars = str.toCharArray();

            int i=0;
            String tmp = "";
            while (i < chars.length) { //组装一个，并置空
                if(chars[i] != ' ') {
                    tmp += chars[i++];
                } else {
                    if(!tmp.equals("")) {
                        deque.push(tmp);
                        System.out.print(tmp+" ");
                    }
                    tmp = "";
                    i++;
                }
            }

            while (!deque.isEmpty()) {
                sb.append(deque.pop()+" ");
            }
            System.out.println(sb);
            //System.out.println(Arrays.toString(strArr));
        }


    }
}

package interview.tx;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @ClassName Test1
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/8/22 19:49
 * @Version 1.0
 **/
public class Test4 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        String str = sc.next();

        Deque<Character> stack = new LinkedList<>();
        stack.push(str.charAt(0));

        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() < str.charAt(i) && stack.size() + n - i < k) {
                stack.pop();
            }
            stack.push(str.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.insert(0, stack.pop());
        }

        System.out.println(sb.toString());
    }
}

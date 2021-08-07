package interview;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @ClassName PDD2
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/7/25 19:40
 * @Version 1.0
 **/
public class PDD2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> a = new LinkedList<>();
        LinkedList<Integer> b = new LinkedList<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int suma = 0;
        int sumb = 0;

        int range = 13;
        int[] book = new int[range];

        int n,t,s;
        for (int i = 0; i < range; i++) {
            book[i] = 0;
        }
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            a.addLast(scanner.nextInt());
        }
        //System.out.println("hahah");
        for (int i = 0; i < n; i++) {
            b.addLast(scanner.nextInt());
        }

        while (!a.isEmpty()&& !b.isEmpty()) {
            t = a.removeFirst();
            if(book[t] == 0) {
                stack.push(t);
                book[t] = 1;
            } else {
                suma++;
                while (!stack.peek().equals(t)) {
                    s = stack.pop();
                    suma++;
                    book[s] = 0;
                }
            }

            t = b.removeFirst();
            if(book[t] == 0) {
                stack.push(t);
                book[t] = 1;
            } else {
                sumb++;
                while (!stack.peek().equals(t)) {
                    s = stack.pop();
                    sumb++;
                    book[s] = 0;
                }
            }
        }

        if(!a.isEmpty()) {
            while (!a.isEmpty()) {
                t = a.removeFirst();
                stack.push(t);
            }
            if(!stack.isEmpty()) {
                for (Integer x:stack) {
                    if(x % 2 == 0) {
                        sumb++;
                    }else {
                        suma++;
                    }
                }
            }
        } else {
            while (!b.isEmpty()) {
                t = b.removeFirst();
                stack.push(t);
            }
            if(!stack.isEmpty()) {
                for (Integer x:stack) {
                    if(x % 2 == 0) {
                        sumb++;
                    }else {
                        suma++;
                    }
                }
            }
        }
        System.out.println(suma+" "+sumb);
    }
}

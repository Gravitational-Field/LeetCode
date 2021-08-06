package interview.baidu;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName Main
 * @Description
 */
public class Main {

    //abbaca

    public static void main(String[] args) {
        String str = "abbaca";  //stack
        System.out.println(new Main().getStr1(str));

    }

    public String getStr1(String str) {
        if (str == null || str.length() == 0 || str.length() == 1) {
            return str;
        }

        Deque<Character> deque = new LinkedList<>();

        //入栈
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (deque.isEmpty()) {
                deque.push(chars[i]);
            } else if (chars[i] == deque.peek()) {
                deque.pop();
            } else {
                deque.push(chars[i]);
            }
        }
        str = "";
        //将栈中的元素取出
        while(!deque.isEmpty()) {
            str = deque.pop()+str;
        }
        return str;
    }

    public String getStr(String str) {
        if (str == null || str.length() == 0 || str.length() == 1) {
            return str;
        }

        while (hasNeighbor(str)) {//进行删去操作
            char[] chars = str.toCharArray();
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] == chars[i - 1]) {
                    String[] split = str.split(chars[i] + "" + chars[i]);
                    str = "";
                    //拼接数组
                    for (int j = 0; j < split.length; j++) {
                        str += split[j];
                    }
//                  System.out.println(str);
                }
            }
        }

        return str;
    }

    private boolean hasNeighbor(String str) { //是否有相邻
        char[] chars = str.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                return true;
            }
        }
        return false;
    }
}

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName Main2
 * @Description
 */
public class Main2 {

    public static Map<Character, Integer> map = new HashMap<>();

    static {
        map.put('a', 2);
        map.put('b', 2);
        map.put('c', 2);
        map.put('d', 3);
        map.put('e', 3);
        map.put('f', 3);
        map.put('g', 4);
        map.put('h', 4);
        map.put('i', 4);
        map.put('j', 5);
        map.put('k', 5);
        map.put('l', 5);
        map.put('m', 6);
        map.put('n', 6);
        map.put('o', 6);
        map.put('p', 7);
        map.put('q', 7);
        map.put('r', 7);
        map.put('s', 7);
        map.put('t', 8);
        map.put('u', 8);
        map.put('v', 8);
        map.put('w', 9);
        map.put('x', 9);
        map.put('y', 9);
        map.put('z', 9);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(getPassword(str));
    }

    private static String getPassword(String str) {
        String res = "";
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a' && chars[i]<='z') {
                res += map.get(chars[i]);
            } else if (chars[i] >= 'A' && chars[i]<='Z') {
                char c = (char)('a' + chars[i] - 'A');
                if (c == 'a') c = 'z';
                else c = (char)(c-1);
                res += map.get(c);
            } else {
                res += chars[i];
            }
        }

        return res; //LIming0701
    }
}

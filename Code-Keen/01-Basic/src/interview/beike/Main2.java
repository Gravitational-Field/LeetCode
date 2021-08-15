package interview.beike;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

    public String NS_String (String s, int k) {
        String result = "";
        ArrayList<Character> clist = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if(!clist.contains(s.charAt(i))) {
                clist.add(s.charAt(i));
            }
        }

        int len = clist.size();
        char[] chars = new char[len];
        for (int i = 0; i < len; i++) {
            chars[i] = clist.get(i);
        }

        Arrays.sort(chars);

        char label = chars[len - 1];
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) > label) {
                result+= s.charAt(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        int a, b;
        while(cin.hasNextInt())
        {
            a = cin.nextInt();
            b = cin.nextInt();
            System.out.println(a + b);
        }

    }
}

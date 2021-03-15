package test;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName JU
 * @Description
 */
public class JU {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();

        List<Integer> list = new LinkedList<>();

        find(str,list);
//        System.out.println(list);
        for (Integer num: list) {
            System.out.println(num);
        }
    }

    private static void find(String str, List<Integer> list) {
        if (str == null) return;
        String regEx="[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        String[] split = m.replaceAll(",").trim().split(",");
        for (int i = 0; i < split.length; i++) {
            if (!split[i].equals("")){
//                System.out.println(Integer.valueOf(split[i]));
                list.add(Integer.valueOf(split[i]));
            }
        }
    }

}

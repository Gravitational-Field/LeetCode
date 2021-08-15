package interview.rongyao;

import java.util.*;

/**
 * @ClassName Test12
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/8/14 19:03
 * @Version 1.0
 **/
public class Test12 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //in.hasNextLine()
        LinkedList<String> list = new LinkedList<>();
        String str;
        while (!"".equals(str = in.nextLine())) {
            list.addLast(str);
        }

        //System.out.println(list.toString());
        Map<String, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).toCharArray()[0] == 'I') {
                map.put(list.get(i).substring(2),0);
            }
        }

        Set<String> strings = map.keySet();
        for (String string : strings) {
            System.out.println(string);
        }



        /*I MusicA Pop
        I MusicB Pop
        I MusicC Blue
        I MusicD Blue
        I MusicE UnkownStyle
        I MusicF Pop
        P MusicA
        P MusicB
        B MusicC
        P MusicF
        B MusicD
        B MusicE*/


    }

}

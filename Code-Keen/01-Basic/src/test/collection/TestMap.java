package test.collection;

import java.util.*;

/**
 * @ClassName TestMap
 * @Description
 */
public class TestMap {


    public static void main(String[] args) {
        LinkedList<Object> list = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        String str = "[1,2,3,4,5]";

        Map<String, String> map = new HashMap<>();
        map.put("1","a");
        map.put("2","b");
        map.put("3","c");
        Set<String> keys = map.keySet();
        for (String str1 :map.keySet()) {
            System.out.println(map.get(str1));
        }

        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry entry: entries) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

        map.forEach((key,value) -> {
            System.out.println(key+": "+value);
        });
    }
}

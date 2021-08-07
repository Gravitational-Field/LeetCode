package test.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName TestHashMap
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/7/30 11:17
 * @Version 1.0
 **/
public class TestHashMap {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "a");
        map.put(1, "a");
        map.put(3, "a");
        map.put(4, "a");

        Set<Integer> integers = map.keySet();
        for (Integer integer : integers) {
            System.out.println(integer+" : "+map.get(integer));
        }
    }
}

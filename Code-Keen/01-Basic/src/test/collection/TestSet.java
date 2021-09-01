package test.collection;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @ClassName TestSet
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/8/25 12:00
 * @Version 1.0
 **/
public class TestSet {

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("abc");
        System.out.println(set.contains("abc"));
        System.out.println( set.size());



    }
}

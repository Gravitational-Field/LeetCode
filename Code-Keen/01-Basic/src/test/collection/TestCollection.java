package test.collection;

import org.junit.Test;

import java.util.*;

/**
 * @ClassName TestCollection
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/6/16 9:49
 * @Version 1.0
 **/
public class TestCollection {

    @Test
    public void test() {
        HashSet<Object> objects = new HashSet<>();
        LinkedHashMap map = new LinkedHashMap();
        LinkedHashSet<Object> objects1 = new LinkedHashSet<>();
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(1);
        System.out.println(integerArrayList.get(1));
        System.out.println(integerArrayList.size());
        ArrayList<Object> list = new ArrayList<>();
        List<Object> list2 = Collections.synchronizedList(list);
        //Map.Entry<Object, Object> entry = new Map.Entry<>();
        HashMap hashMap = new HashMap();
        TreeMap<Object, Object> objectObjectTreeMap = new TreeMap<>();

    }
}

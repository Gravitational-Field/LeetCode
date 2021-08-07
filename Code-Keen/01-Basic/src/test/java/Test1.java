package test.java;

import java.math.BigDecimal;
import java.util.*;

/**
 * @ClassName Test1
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/5/31 11:40
 * @Version 1.0
 **/
public class Test1 {

    public static void main(String[] args) throws CloneNotSupportedException {
        /*if (1 == 0.99999999999999999) { // true
            System.out.println("true");
        }
        String str = "hello";
        System.out.println(str.hashCode());*/

        Boolean b = Boolean.TRUE;
        Person p1 = new Person();
        p1.setAge(18);
        p1.setName("keen");
        Person p2 = (Person) p1.clone();
        System.out.println(p2);
        final int a;
        System.out.println(a = 10);
        //System.out.println(a=11);
        //int b;
        //System.out.println(b);
        int[] array = new int[1];
        String str = null;
        System.out.println(str);
        System.out.println(Arrays.toString(array));

        String str1 = "";
        new Exception();
        //Objects.equals()
        /*BigDecimal b1 = new BigDecimal("3.14");
        BigDecimal b2 = new BigDecimal("0.223");
        System.out.println(b1.add(b2));  //3.363*/
        List<String> list = new ArrayList(Arrays.asList("hello", "and", "world"));

        //list.add("you"); //UnsupportedOperationException
        System.out.println(list.toString());
        System.out.println(list.size()); //3
        /*for (String str2:list) {
            System.out.println(str2);
        }
        for (String s : list) {

        }*/
        Iterator<String> iter = list.iterator();

        while (iter.hasNext()) {
            String sss = iter.next();
            if(sss.equals("and")) {
                iter.remove();
            }
        }

        //for (String str2:list) {
        //    System.out.println(str2);
        //}

        list.removeIf(filter -> filter == "and");  //[hello, world]
        System.out.println(list);

        /*ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(12);
        numbers.add(8);
        numbers.add(2);
        numbers.add(23);
        Iterator<Integer> it = numbers.iterator();
        while(it.hasNext()) {
            Integer i = it.next();
            if(i < 10) {
                it.remove();  // 删除小于 10 的元素
            }
        }
        System.out.println(numbers);*/
        //new HashMap<>()
    }
}

package cn.array;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestFile {
    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>(); //定义Integer泛型
        String str = "abc";
        Method[] method = list.getClass().getMethods();//取得list的所有方法
        System.out.println(method.length);
        for (Method value : method) {
            System.out.println(value);//遍历打印list的方法
        }
        method[0].invoke(list, str);//通过反射来执行list的第一个方法,第一个是list对象,代表该对象的方法,第二个是方法参数:  就是list.add(str);
        System.out.println(list.size());
        for (Integer integer : list) System.out.println(integer);
    }
}
package test.singleton;

/**
 * @ClassName Singleton1
 * @Description: 饿汉式 : 无线程安全问题
 * @Author Keen
 * @DATE 2021/7/5 10:57
 * @Version 1.0
 **/
public class Singleton1 {

    public static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {
    }

}

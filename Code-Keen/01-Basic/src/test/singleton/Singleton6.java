package test.singleton;

/**
 * @ClassName Singleton6
 * @Description: 饿汉式，多线程，静态内部类
 * @Author Keen
 * @DATE 2021/7/5 15:27
 * @Version 1.0
 **/
public class Singleton6 {
    private Singleton6() {}

    private static class Inner {  //内部类加载：静态内部类不会随着外部类的加载而加载，而是在第一次调用内部类时才会加载
        private static final Singleton6 instance = new Singleton6();
    }

    public static Singleton6 getInstance() {
        return Inner.instance;
    }

}

package test.singleton;

/**
 * @ClassName Singleton4
 * @Description: 懒汉式：在调用接口时才使用,是线程不安全的
 * @Author Keen
 * @DATE 2021/7/5 14:09
 * @Version 1.0
 **/
public class Singleton4 {

    private static Singleton4 INSTANCE;
    private Singleton4() {
    }
    public static Singleton4 getInstance() {
        if(INSTANCE == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Singleton4();
        }
        return INSTANCE;
    }
}

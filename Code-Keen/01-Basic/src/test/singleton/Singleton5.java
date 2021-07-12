package test.singleton;

/**
 * @ClassName Singleton5
 * @Description: 懒汉式：线程安全
 * @Author Keen
 * @DATE 2021/7/5 14:09
 * @Version 1.0
 **/
public class Singleton5 {

    private static Singleton5 INSTANCE;
    private Singleton5() {
    }
    public static Singleton5 getInstance() { //synchronized
        if(INSTANCE == null) {
            synchronized (Singleton5.class) {
                if (INSTANCE == null) {
                    try { //sleep会让出同步锁
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Singleton5();
                }
            }
        }
        return INSTANCE;
    }
}

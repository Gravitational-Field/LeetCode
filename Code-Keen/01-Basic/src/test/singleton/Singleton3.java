package test.singleton;

import java.io.InputStream;
import java.util.Properties;

/**
 * @ClassName Singleton1
 * @Description: 饿汉式 : 使用静态代码块实现复杂的类初始化
 * @Author Keen
 * @DATE 2021/7/5 10:57
 * @Version 1.0
 **/
public class Singleton3 {

    public static final Singleton3 INSTANCE;
    private String info;

    static {
        try {
            Properties prop = new Properties();
            prop.load(Singleton3.class.getClassLoader().getResourceAsStream("singleton.properties"));
            System.out.println(prop.getProperty("info"));
            INSTANCE = new Singleton3(prop.getProperty("info"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private Singleton3(String info) {
        this.info = info;
    }

}

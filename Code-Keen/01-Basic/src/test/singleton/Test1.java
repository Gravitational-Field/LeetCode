package test.singleton;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @ClassName Test
 * @Description: 测试类
 * @Author Keen
 * @DATE 2021/7/5 13:59
 * @Version 1.0
 **/
public class Test1 {

    @Test
    public void testSingleton1() {
        //测试单例对象
        Singleton1 ins1 = Singleton1.INSTANCE;
        Singleton1 ins2 = Singleton1.INSTANCE;
        System.out.println(ins1 == ins2); //true
    }

    @Test
    public void testSingleton2() {
        //测试单例对象
        Singleton2 ins1 = Singleton2.INSTANCE;
        Singleton2 ins2 = Singleton2.INSTANCE;
        System.out.println(ins1 == ins2); //true
    }

    @Test
    public void testSingleton3() {
        //测试单例对象
        Singleton3 ins1 = Singleton3.INSTANCE;
        Singleton3 ins2 = Singleton3.INSTANCE;
        System.out.println(ins1 == ins2);  //true
    }

    @Test  // 懒汉式，如何造成线程安全线程？
    public void testSingleton4() throws ExecutionException, InterruptedException {
        //测试单例对象
        /*Singleton4 ins1 = Singleton4.getInstance();
        Singleton4 ins2 = Singleton4.getInstance();
        System.out.println(ins1 == ins2);  //true
        System.out.println(ins1);
        System.out.println(ins2);*/

        //线程不安全问题
        Callable<Singleton4> callable = new Callable() {
            @Override
            public Object call() throws Exception {
                return Singleton4.getInstance();
            }
        };

        ExecutorService exec = Executors.newCachedThreadPool();
        Future<Singleton4> f1 = exec.submit(callable);
        Future<Singleton4> f2 = exec.submit(callable);

        Singleton4 ins1 = f1.get();  //获取两个线程的返回值
        Singleton4 ins2 = f2.get();

        exec.shutdown();  //关闭线程连接池

        System.out.println(ins1 == ins2);  //true
        System.out.println(ins1);
        System.out.println(ins2);

    }

    @Test  // 懒汉式，多线程安全的方式
    public void testSingleton5() throws ExecutionException, InterruptedException {
        //测试单例对象
        /*Singleton5 ins1 = Singleton5.getInstance();
        Singleton5 ins2 = Singleton5.getInstance();
        System.out.println(ins1 == ins2);  //true
        System.out.println(ins1);
        System.out.println(ins2);*/

        //线程不安全问题
        Callable<Singleton5> callable = new Callable() {
            @Override
            public Object call() throws Exception {
                return Singleton5.getInstance();
            }
        };

        ExecutorService exec = Executors.newCachedThreadPool();
        Future<Singleton5> f1 = exec.submit(callable);
        Future<Singleton5> f2 = exec.submit(callable);

        Singleton5 ins1 = f1.get();  //获取两个线程的返回值
        Singleton5 ins2 = f2.get();

        System.out.println(ins1 == ins2);  //true
        System.out.println(ins1);
        System.out.println(ins2);
    }

    @Test  // 懒汉式，多线程安全的方式
    public void testSingleton6() throws ExecutionException, InterruptedException {
        //测试单例对象
        /*Singleton6 ins1 = Singleton6.getInstance();
        Singleton6 ins2 = Singleton6.getInstance();
        System.out.println(ins1 == ins2);  //true
        System.out.println(ins1);
        System.out.println(ins2);*/

        //线程不安全问题
        Callable<Singleton6> callable = new Callable() {
            @Override
            public Object call() throws Exception {
                return Singleton6.getInstance();
            }
        };

        ExecutorService exec = Executors.newCachedThreadPool();
        Future<Singleton6> f1 = exec.submit(callable);
        Future<Singleton6> f2 = exec.submit(callable);

        Singleton6 ins1 = f1.get();  //获取两个线程的返回值
        Singleton6 ins2 = f2.get();

        System.out.println(ins1 == ins2);  //true
        System.out.println(ins1);
        System.out.println(ins2);
    }


    public static void main(String[] args) {
        //测试单例对象
        Singleton3 ins1 = Singleton3.INSTANCE;
        Singleton3 ins2 = Singleton3.INSTANCE;
        System.out.println(ins1 == ins2);  //true
    }

}

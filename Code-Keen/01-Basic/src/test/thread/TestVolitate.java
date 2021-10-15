package test.thread;

/*import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;*/

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @ClassName TestVolitate
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/7/28 15:03
 * @Version 1.0
 **/
public class TestVolitate {

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(()->{


            },"A"+i).start();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {

            }, String.valueOf(i)).start();
        }


        while(Thread.activeCount() > 2) {
            Thread.yield();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {

            }, String.valueOf(i)).start();
        }

    }


}

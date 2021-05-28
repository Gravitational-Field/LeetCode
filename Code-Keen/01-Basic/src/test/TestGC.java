package test;

import org.junit.Test;

import java.lang.ref.Reference;

/**
 * @ClassName TestGC
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/5/24 10:28
 * @Version 1.0
 **/

public class TestGC {

    public static void main(String[] args) {

        /*byte[] allocation1, allocation2,allocation3,allocation4,allocation5;
        allocation1 = new byte[32000*1024];
        allocation2 = new byte[1000*1024];
        allocation3 = new byte[1000*1024];
        allocation4 = new byte[1000*1024];
        allocation5 = new byte[1000*1024];*/
        byte[] allocation1, allocation2;
        allocation1 = new byte[Integer.MIN_VALUE / 2];
        allocation2 = new byte[900 * 1024];
        //Reference
    }
}

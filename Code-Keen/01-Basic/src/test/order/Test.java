package test.order;

import java.util.Arrays;

/**
 * @ClassName Test
 * @Description
 */
public class Test {

    @org.junit.Test
    public void testSelection() {
        Integer[] array = {5,7,1,3,2,6,8,9,4,0};
        long start = System.currentTimeMillis();
        long startTime=System.nanoTime();   //获取开始时间
        new Selection<Integer>().sort(array);

        System.out.println(Arrays.asList(array));
        long end = System.currentTimeMillis();
        long endTime=System.nanoTime(); //获取结束时间
        System.out.println("运行时间： "+(end-start) + "ms");  // 2ms
        System.out.println("程序运行时间： "+(endTime-startTime)+"ns");  // 1433800ns
    }

    @org.junit.Test
    public void testBubble() {
        Integer[] array = {5,7,1,3,2,6,8,9,4,0};
        long start = System.currentTimeMillis();
        long startTime=System.nanoTime();   //获取开始时间
        new Bubble<Integer>().sort(array);

        System.out.println(Arrays.asList(array));
        long end = System.currentTimeMillis();
        long endTime=System.nanoTime(); //获取结束时间
        System.out.println("运行时间： "+(end-start) + "ms");  // 4ms   优化后  2ms
        System.out.println("程序运行时间： "+(endTime-startTime)+"ns");  // 3669200ns   优化后  2006200ns
    }

    @org.junit.Test
    public void testInsertion() {
        Integer[] array = {5,7,1,3,2,6,8,9,4,0};
        long start = System.currentTimeMillis();
        long startTime=System.nanoTime();   //获取开始时间
        new Insertion<Integer>().sort(array);

        System.out.println(Arrays.asList(array));
        long end = System.currentTimeMillis();
        long endTime=System.nanoTime(); //获取结束时间
        System.out.println("运行时间： "+(end-start) + "ms");  //  2ms
        System.out.println("程序运行时间： "+(endTime-startTime)+"ns");  // 1661400ns
    }




}

package test.thread;

import jdk.nashorn.internal.codegen.CompilerConstants;

import java.util.concurrent.*;

/**
 * @ClassName ThreadArchitecture
 * @Description
 */
public class ThreadArchitecture extends RecursiveTask implements Callable<String> {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread thread = new Thread();
        /*{
            @Override
            public String call() throws Exception {
                System.out.println();
                return "abc";
            }
        };*/
        FutureTask<String> stringFutureTask = new FutureTask<String>(new ThreadArchitecture());
        Thread thread1 = new Thread(stringFutureTask);
        thread1.start();
        System.out.println(stringFutureTask.get());


        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->{
            System.out.println();
        });

        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();

        new Thread(()->{
            System.out.println("hello");
        }).start();

//        BlockingQueue
//        ForkJoinPool
        /*ForkJoinPool forkJoinPool = new ForkJoinPool();
        Future result = forkJoinPool.submit(example);*/
        Integer i = 100;
        System.out.println(i+11); //111
//        Integer integer = new Integer(99);
        i = i+1;
        System.out.println(i);



    }


    @Override
    public String call() throws Exception {
        return "xxx";
    }

    @Override
    protected Object compute() {
        return null;
    }
}

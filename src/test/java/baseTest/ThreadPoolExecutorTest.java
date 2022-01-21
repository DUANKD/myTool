package baseTest;

import cn.hutool.core.thread.NamedThreadFactory;
import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

/**
 * @author duankd
 * @ClassName ThreadPoolExecutorTest
 * @date 2021-11-24 15:29:17
 */
public class ThreadPoolExecutorTest {
    @Test
    void test1() {
        int corePoolSize = 1;
        int maximumPoolSize = 10;
        long keepAliveTime = 60;
        TimeUnit unit = TimeUnit.MINUTES;
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();
        ThreadFactory threadFactory = new NamedThreadFactory("prefix-", false);
        RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardPolicy();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                unit,
                workQueue,
                threadFactory,
                handler);
        RunnableTask runnableTask1 = new RunnableTask("Jerry");
        RunnableTask runnableTask2 = new RunnableTask("Cissie");

        // execute方法执行Runnable类型的任务
        threadPoolExecutor.execute(runnableTask1);
        threadPoolExecutor.execute(runnableTask2);
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("run");
            }
        });

        // 关闭线程池
        threadPoolExecutor.shutdown();


        // 用Executors类的工场方法初始化线程池
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);

        // 初始化Callable类型的任务
        MyCallableTask myCallableTask1 = new MyCallableTask(100);
        MyCallableTask myCallableTask2 = new MyCallableTask(200);

        Future<Integer> future1 = fixedThreadPool.submit(myCallableTask1);
        Future<Integer> future2 = fixedThreadPool.submit(myCallableTask2);

        // 关闭线程池
        fixedThreadPool.shutdown();

        // 主线程获取异步任务的执行结果
        System.out.println("主线程获取异步任务的执行结果");
        try {
            System.out.println("Future1的结果: " + future1.get());
            System.out.println("Future2的结果: " + future2.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    void test2() {
        // 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
        Executors.newFixedThreadPool(10);
        //创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
        Executors.newCachedThreadPool();
        //创建一个定长线程池，支持定时及周期性任务执行。
        Executors.newScheduledThreadPool(10);
        //创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
        Executors.newSingleThreadExecutor();
    }

    static class RunnableTask implements Runnable {
        String val;

        public RunnableTask(String val) {
            this.val = val;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "执行Runnable任务，打印值：" + this.val);
        }
    }

    static class MyCallableTask implements Callable<Integer> {
        int sum;

        public MyCallableTask(int sum) {
            this.sum = sum;
        }

        @Override
        public Integer call() throws Exception {
            System.out.println(Thread.currentThread().getName() + "执行Callable任务");
            for (int i = 0; i < 100; ++i) {
                sum += i;
            }
            return sum;
        }
    }
}

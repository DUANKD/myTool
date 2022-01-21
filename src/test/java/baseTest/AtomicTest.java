package baseTest;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author duankd
 * @ClassName AtomicTest
 * @date 2021-10-29 15:37:58
 */
public class AtomicTest {

    @Test
    void atomicLongTest() throws InterruptedException {
        long num = 10000L;
        AtomicLong atomicLong = new AtomicLong(num);
        LongAdder longAdder = new LongAdder();
        longAdder.add(num);
        {
            int threadNum=50;
            final CountDownLatch countDownLatch=new CountDownLatch(threadNum);
            Runnable script = new Runnable() {
                @Override
                public void run() {
                    for (long i = 0; i < num; i++) {
                        atomicLong.addAndGet(1);
                    }
                    countDownLatch.countDown();
                }
            };
            Thread[] threads=new Thread[threadNum];
            for (int i = 0; i < threadNum; i++) {
                threads[i]=new Thread(script);
            }
            final long start = System.nanoTime();
            for (int i = 0; i < threadNum; i++) {
                threads[i].start();
                //threads[i].join();
            }
            countDownLatch.await();
            final long start1 = System.nanoTime();
            System.out.println("AtomicLong处理时间： " + (double) (start1 - start) / 1000000 + " ms, 结果为" + atomicLong.longValue());
        }

        {
            int threadNum=50;
            final CountDownLatch countDownLatch=new CountDownLatch(threadNum);
            Runnable script = new Runnable() {
                @Override
                public void run() {
                    for (long i = 0; i < num; i++) {
                        longAdder.add(1);
                    }
                    countDownLatch.countDown();
                }
            };
            Thread[] threads=new Thread[10];
            for (int i = 0; i < threadNum; i++) {
                threads[i]=new Thread(script);
            }
            final long start = System.nanoTime();
            for (int i = 0; i < threadNum; i++) {
                threads[i].start();
                //threads[i].join();
            }
            countDownLatch.await();
            final long start1 = System.nanoTime();
            System.out.println("LongAdder处理时间： " + (double) (start1 - start) / 1000000 + " ms, 结果为" + atomicLong.longValue());
        }
    }
}

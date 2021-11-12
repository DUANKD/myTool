package baseTest;

import com.mytool.base.utils.T01_CacheLinePadding;
import com.mytool.base.utils.T02_CacheLinePadding;
import org.apache.poi.ss.formula.functions.T;
import org.junit.jupiter.api.Test;

/**
 * @author duankd
 * @ClassName CacheLinePaddingTest
 * @date 2021-10-29 12:14:06
 */
public class CacheLinePaddingTest {

    private static class Padding {
        public volatile long p1, p2, p3, p4, p5, p6, p7;
    }

    private static class T1 extends Padding {
        public volatile long x = 0L;
    }

    private static class T2 {
        public volatile long x = 0L;
    }

    static T1[] orr1 = new T1[2];
    static T2[] orr2 = new T2[2];

    static {
        orr1[0] = new T1();
        orr1[1] = new T1();
        orr2[0] = new T2();
        orr2[1] = new T2();
    }

    @Test
    void test1() throws InterruptedException {
        long count = 1000_000L;
        Thread t1 = new Thread(() -> {
            for (long i = 0; i < count; i++) {
                orr1[0].x = i;
            }
        });
        Thread t2 = new Thread(() -> {
            for (long i = 0; i < count; i++) {
                orr1[1].x = i;
            }
        });
        Thread t3 = new Thread(() -> {
            for (long i = 0; i < count; i++) {
                orr2[0].x = i;
            }
        });
        Thread t4 = new Thread(() -> {
            for (long i = 0; i < count; i++) {
                orr2[1].x = i;
            }
        });
        final long start = System.nanoTime();
        final long startMs = System.currentTimeMillis();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        final long start1 = System.nanoTime();
        final long startMs1 = System.currentTimeMillis();
        //System.out.println("内存对齐处理时间： " + (start1 - start) / 1000000 + " ms");
        System.out.println("内存对齐处理时间： " + (double)(start1 - start)/ 1000000 + " ms");
        System.out.println("内存对齐处理时间： " + (startMs1 - startMs) + " ms");
        final long start2 = System.nanoTime();
        t3.start();
        t4.start();
        t3.join();
        t4.join();
        System.out.println("内存不对齐处理时间： " + (System.nanoTime() - start2) / 1000000 + " ms");
    }
}

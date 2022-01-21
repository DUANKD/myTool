package baseTest;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Semaphore;

/**
 * @author duankd
 * @ClassName SemaphoreTest
 * @date 2021-11-29 14:51:11
 */
public class SemaphoreTest {

    @Test
    void test1() {
        Semaphore semaphore=new Semaphore(15);
        try {
            semaphore.acquire(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release(15);
    }

}

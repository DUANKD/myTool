package threadTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duankd
 * @ClassName ThreadLocalTest
 * @date 2021-05-14 16:31:39
 */
public class ThreadLocalTest {
    @Test
    public void threadLocalTest() {
        ThreadLocal<List<Integer>> localCache = new ThreadLocal<>();
        List<Integer> cacheInstance = new ArrayList<>(10000);
        localCache.set(cacheInstance);
        localCache = new ThreadLocal<>();
    }
}
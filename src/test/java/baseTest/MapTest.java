package baseTest;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author duankd
 * @ClassName MapTest
 * @date 2020-12-11 9:34:43
 */
public class MapTest {

    @Test
    public void ashMapTest() {
        Map<String, String> map = new HashMap<>();
        int cap = 1;
        int n = cap - 1;
        n |= n >>> 1;
        map.put("", "");
        map.get("");
        System.out.println("");
    }

    @Test
    public void name() {
        int a = 1 << 30;
        int a1 = a >>> 1;
        int b1 = -1 >>> 1;
        int b2 = -1 >> 4;
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>(16);
        concurrentHashMap.put("a", "a");
        concurrentHashMap.put("b", "a");
        concurrentHashMap.put("b", "a");
        System.out.println(concurrentHashMap);

    }

    @Test
    public void name1() {
    }
}

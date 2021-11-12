package baseTest;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
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
        HashMap<String, String> map = new HashMap<>(16);
        int cap = 1;
        int n = cap - 1;
        n |= n >>> 1;
        map.put("", "");
        map.get("");
        map.remove("");
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
        String result = concurrentHashMap.get("a");
        concurrentHashMap.remove("a");
        System.out.println(concurrentHashMap);

    }

    @Test
    public void name1() {
        HashSet<String> hashSet = new HashSet<>(16);
        hashSet.add("a");
        hashSet.add("b");
        boolean result = hashSet.contains("a");
        hashSet.remove("a");
        System.out.println(hashSet);
    }


    @Test
    public void parseInt() {
        int n = 18;
        //10进制转2进制
        System.out.println(n + "的二进制是:" + Integer.toBinaryString(n));
        //10进制转8进制
        System.out.println(n + "的八进制是:" + Integer.toOctalString(n));
        //10进制转16进制
        System.out.println(n + "的十六进制是:" + Integer.toHexString(n));
        //10进制转 r 进制
        System.out.println(n + "的三进制是:" + Integer.toString(n, 3));

        //r进制转10进制 -radix进制的字符串s转10进制
        String s = "10101";//1+4+16==21
        System.out.println(Integer.parseInt(s,2));//结果是21
    }
}

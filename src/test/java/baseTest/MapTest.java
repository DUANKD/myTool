package baseTest;

import com.mytool.model.TestModel;
import org.junit.Test;

import java.util.*;
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
        concurrentHashMap.size();
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
        System.out.println(Integer.parseInt(s, 2));//结果是21
    }

    @Test
    public void hashMapTest() {
        Map<String, TestModel> map = new HashMap<>(16);
        List<TestModel> list = new ArrayList<>();
        TestModel testModel = new TestModel();
        testModel.setLongNumber(1L);
        map.put("1", testModel);
        list.add(testModel);
        {

            TestModel testModel1 = map.get("1");
            testModel1.setLongNumber(2L);

            TestModel testModel2 = new TestModel();
            testModel2.setLongNumber(333L);
            testModel1 = testModel2;
        }
        map.remove("");
        System.out.println(map.get("1"));
        System.out.println(map);
        System.out.println(list);
        Map<String, TestModel> map1 = map;
        {

            TestModel testModel1 = map1.get("1");
            testModel1.setLongNumber(78L);

            TestModel testModel2 = new TestModel();
            testModel2.setLongNumber(44L);
            testModel1 = testModel2;
            map1.put("3", testModel);
            System.out.println("map1:"+map1);
            System.out.println("map:"+map);

        }
        Long a = null;
        System.out.println("result_" + a);
    }
}

package baseTest;

import org.junit.jupiter.api.Test;

/**
 * @author duankd
 * @ClassName ThreadLocalTest
 * @date 2021-11-24 9:29:48
 */
public class ThreadLocalTest {
    @Test
    void test1() {
        ThreadLocal<String> localStr=new ThreadLocal<>();
        localStr.set("test");
        localStr.set("test2");
        String result=localStr.get();
        localStr.remove();
        String result1=localStr.get();
        System.out.println(result);
        System.out.println(result1);
    }

    @Test
    void fastTest() {

    }


}

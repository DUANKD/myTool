package baseTest;

import org.junit.jupiter.api.Test;

/**
 * @author duankd
 * @ClassName IntegerTest
 * @date 2021-11-19 18:01:38
 */
public class IntegerTest {
    @Test
    void test1() {
        int a = (int)((double)3 / 2);
        System.out.println(a);
        int a1 = (int) Math.ceil((double) 3/2);
        System.out.println(a1);
        int a2 = (int) Math.floor((double)3/2);
        System.out.println(a2);
    }
}

package baseTest;

import org.junit.Test;
import org.springframework.util.StringUtils;

/**
 * @author duankd
 * @ClassName LambdaTest
 * @date 2021-05-19 16:24:53
 */
public class LambdaTest {

    @FunctionalInterface
    public interface StringFilter {
        boolean matches(String var1);
    }

    static class StringFilterImpl implements StringFilter {
        @Override
        public boolean matches(String var1) {
            System.out.println("aaa");
            return true;
        }
    }

    static boolean isEmpty(String s) {
        return StringUtils.isEmpty(s);
    }

    public static boolean selectMethods(String s, LambdaTest.StringFilter stringFilter) {
        return stringFilter.matches(s);
    }

    @Test
    public void staticMethodUse() {
        String str = "aaa";
        //Supplier<Boolean> supplier = (a) -> isEmpty(a);
        StringFilter stringFilter = (a) -> isEmpty(a);
        boolean result = selectMethods(str, stringFilter);
        System.out.println(result);
    }
}

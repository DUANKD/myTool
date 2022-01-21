package baseTest;

import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;

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


    private static Map<String, Function<String,String>> functionMap=new HashMap<>();

    private static void initFunctionMap(){
        functionMap.put("判空",resourceId-> String.valueOf(isEmpty(resourceId)));
        functionMap.put("小写",resourceId->resourceId.toLowerCase());
        functionMap.put("大写",resourceId->resourceId.toUpperCase());
        functionMap.put("替换",resourceId->resourceId.replaceAll("a","b"));
    }

    @Test
    public void functionTest() {
        initFunctionMap();
        String data="aaaa";
        for (Map.Entry<String, Function<String, String>> entry : functionMap.entrySet()) {
            String request=entry.getKey();
            Function<String,String> function=functionMap.get(request);
            String result= function.apply(data);
            System.out.println(" 处理方法："+request +" ，结果："+result);
        }
        System.out.println("结束！");
    }
}

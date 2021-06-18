package baseTest;

import com.mytool.model.TestModel;
import org.junit.Test;

/**
 * @author duankd
 * @ClassName MapTest
 * @date 2020-12-11 9:34:43
 */
public class StringTest {

    private static String testStr = "aaa";


    @Test
    public void transferTest() {
        String testStr1 = "aaa";
        changeStr(testStr1);
        System.out.println(testStr1);
        TestModel testModel = new TestModel();
        testModel.setContext("testStr");
        changeTestModel(testModel);
        System.out.println(testModel.getContext());
    }

    private static String changeStr(String str) {
        str = "bbbb";
        return str;
    }

    private static void changeTestModel(TestModel testModel) {
        testModel.setContext("bbbb");
    }

    @Test
    public void replace() {
        String a = "We are family";
        String b = a.replace(" ", "%20");
        System.out.println(b);
    }

    @Test
    public void transferIntTest() {
        String rights = "111111111111";
        long intNum = Long.parseLong(rights);
        long result = intNum | 0b000000000000;
        System.out.println(result);
    }

    @Test
    public void forcedConversion() {
        Integer a = 255;
        Object b = a;
        String c1 = (String) b;
        String c2 = a.toString();
        String c3 = b.toString();
        System.out.println(c2);
    }

    @Test
    public void subString() {
        String a = "abcdef";
        String b = a.substring(0, 1);
        String c = a.substring(6 - 2, 6);
        System.out.println(a);
    }
}

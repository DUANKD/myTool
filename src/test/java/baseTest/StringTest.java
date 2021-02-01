package baseTest;

import com.mytool.model.TestModel;
import org.junit.Test;

/**
 * @author duankd
 * @ClassName MapTest
 * @date 2020-12-11 9:34:43
 */
public class StringTest {

    private static String testStr="aaa";



    @Test
    public void transferTest(){
        String testStr1="aaa";
        changeStr(testStr1);
        System.out.println(testStr1);
        TestModel testModel=new TestModel();
        testModel.setContext("testStr");
        changeTestModel(testModel);
        System.out.println(testModel.getContext());
    }

    private static String changeStr(String str){
        str="bbbb";
        return str;
    }

    private static void changeTestModel(TestModel testModel){
        testModel.setContext("bbbb");
    }
}

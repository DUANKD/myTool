package baseTest;

import com.mytool.model.TestModel;
import com.mytool.model.TestModelOver;
import org.junit.jupiter.api.Test;

/**
 * @author duankd
 * @ClassName OverrideTest
 * @date 2021-03-17 9:49:21
 */
public class OverrideTest {
    @Test
    public void over() {
        TestModelOver testModelOver = new TestModelOver();
        testModelOver.setContext1("111");
        testModelOver.setContext("000");
        TestModel testModel = testModelOver;
        TestModel testModel1 = new TestModelOver();
        TestModelOver testModelOver1 = (TestModelOver) testModel;
        TestModelOver testModelOver2 = (TestModelOver) transform(testModel);
        System.out.println(testModelOver1);
    }

    private static TestModel transform(TestModel test) {
        TestModelOver testModelOver = (TestModelOver) test;
        return testModelOver;
    }
}

package json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mytool.model.TestModel;
import org.junit.Test;

/**
 * @author duankd
 * @ClassName JsonTransformTest
 * @date 2020-12-22 9:43:50
 */
public class JsonTransformTest {

    @Test
    public void escapeTest() {
        TestModel testModel = new TestModel();
        testModel.setContext("aaaaa");
        testModel.setLongNumber(9223372036854775807L);
        String json = JSON.toJSONString(testModel);
        //String json = "";
        JSONObject jsonObject = JSON.parseObject(json);
        TestModel testModel1 = JSON.parseObject(json, TestModel.class);
        if (testModel.getLongNumber().equals(testModel1.getLongNumber())) {
            System.out.println("yes!");
        } else {
            System.out.println("no!");
        }
        String jsonStr = jsonObject.toJSONString();
        System.out.println(jsonStr);
    }
}

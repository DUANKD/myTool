package json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.mytool.model.TestModel;
import com.mytool.model.TestModelTemp;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void jsonTransform() {
        TestModel testModel = new TestModel();
        testModel.setContext("123");
        testModel.setLongNumber(1234L);
        Gson gson = new Gson();
        String jsonData = gson.toJson(testModel);
        TestModelTemp testModelTemp = gson.fromJson(jsonData, TestModelTemp.class);
        System.out.println(testModelTemp);
    }

    @Test
    public void jsonTransformListToStr() {
        List<TestModel> list= new ArrayList<>();
        TestModel testModel = new TestModel();
        testModel.setContext("aaa");
        list.add(testModel);
        String str=JSON.toJSONString(list);
        System.out.println(str);
    }

    @Test
    public void jsonTransformToStr() {
        TestModel testModel = new TestModel();
        testModel.setContext("aaa");
        testModel.setLongNumber(1L);
        //testModel.setLongNumber2(2L);
        String str=JSON.toJSONString(testModel);
        System.out.println(str);
    }

    @Test
    public void jsonTransform4Str() {
        String str="{\"context\":\"aaa\",\"longNumber\":1,\"longNumber2\":2}";
        TestModel testModel =JSON.parseObject(str,TestModel.class);
        System.out.println(testModel);
    }
}

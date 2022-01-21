package json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mytool.model.TestModel;
import com.mytool.model.TestModelTemp;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<TestModel> list = new ArrayList<>();
        TestModel testModel = new TestModel();
        testModel.setContext("aaa");
        list.add(testModel);
        String str = JSON.toJSONString(list);
        System.out.println(str);
    }

    @Test
    public void jsonTransformLongListToStr() {
        List<Long> list = new ArrayList<>();
        list.add(123L);
        list.add(122L);
        String str = JSON.toJSONString(list);
        List<Long> listT = JSON.parseArray(str, Long.class);
        List<Long> students = JSON.parseObject(str, new TypeReference<List<Long>>() {
        }); // Json 转List
        boolean exist = listT.contains(122L);
        boolean exist1 = listT.contains(121L);
        System.out.println(str);
    }

    @Test
    public void jsonTransformStringListToStr() {
        List<String> list = new ArrayList<>();
        list.add("asd");
        list.add("sada");
        String str = JSON.toJSONString(list);
        List<String> listT = JSON.parseArray(str, String.class);
        List<String> students = JSON.parseObject(str, new TypeReference<List<String>>() {
        }); // Json 转List
        boolean exist = listT.contains("asd");
        boolean exist1 = listT.contains("asd1");
        System.out.println(str);
    }

    @Test
    public void jsonTransformToStr() {
        TestModel testModel = new TestModel();
        testModel.setContext("aaa");
        testModel.setLongNumber(1L);
        //testModel.setLongNumber2(2L);
        String str = JSON.toJSONString(testModel);
        System.out.println(str);
        List<String> a = new ArrayList<>();
        a.add("sadad");
        a.add("sadad");
        List<TestModel> b = new ArrayList<>();
        b.add(testModel);
        TestModel testModel1 = new TestModel();
        testModel1.setContext("aaa");
        testModel1.setLongNumber(2L);
        b.add(testModel1);
        Map<String, Object> map = new HashMap<>();
        map.put("list", a);
        JSONObject data = new JSONObject();
        data.put("a", a);
        data.put("test", testModel);
        data.put("map", map);
        data.put("modelList", b);

        System.out.println(data.toJSONString());


    }

    @Test
    public void mapToStr() {
        Map<String, Object> map = new HashMap<>();
        List<String> a = new ArrayList<>();
        a.add("sadad");
        a.add("sadad");
        map.put("list", a);

        TestModel testModel = new TestModel();
        testModel.setContext("aaa");
        testModel.setLongNumber(2L);
        map.put("testModel", testModel);

        String value = JSON.toJSONString(map);
        Map<String, Object> map1 = JSON.parseObject(value, new TypeReference<HashMap<String, Object>>() {
        });
        System.out.println(map1);
        System.out.println(map1.equals(map));
    }

    @Test
    public void jsonTransform4Str() {
        String str = "{\"context\":\"aaa\",\"longNumber\":1,\"longNumber2\":2}";
        TestModel testModel = JSON.parseObject(str, TestModel.class);
        System.out.println(testModel);
    }

    @Test
    public void jsonTransform4Str1() {
        String str = "\"214253198913\\t1130131300\\t330916870739089\\t60\\t19\\t2021-07-30 15:39:27\\t183.63.90.60\\t1\\t恢复 ,回收站测试 (75).action\\t广东,广州\\t4142533391441568\\t\\t\\t\"";
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String result = gson.fromJson(str, String.class);
        System.out.println(result);
    }
}

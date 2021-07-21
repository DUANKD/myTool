package json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mytool.base.utils.MyFileUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duankd
 * @ClassName JsonReadTest
 * @date 2020-12-22 9:43:50
 */
public class JsonReadTest {
    static String Delete_Es_Str = "curl -XDELETE http://172.18.11.12:59200/jd_index/jdSku/#{skuId}_SJLXXWLYXZRGS-201806 -v;";


    @Test
    public void orderTest() {
        String fileName = "C:\\Users\\Administrator\\Desktop\\response.json";
        String jsonStr = MyFileUtil.getFromJson(fileName);
        try {
            JSONObject totalJson = JSONObject.parseObject(jsonStr);

            JSONArray jsonArray = totalJson.getJSONObject("result").getJSONArray("goods");
            List<String> deleteEsStrList = new ArrayList<>();
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jo = jsonArray.getJSONObject(i);
                String deleteEsStr = Delete_Es_Str;
                if (jo.containsKey("skuId")) {
                    String skuId = jo.getString("skuId");
                    deleteEsStr = deleteEsStr.replace("#{skuId}", skuId);
                    deleteEsStrList.add(deleteEsStr);
                }
            }
            ;
            /*Map<String, String> map = JSONObject.parseObject(
                    //jsonObject.getString("data"),
                    totalJson.toJSONString(), new TypeReference<Map<String, String>>() {});*/

            System.out.println("\n\n#删除es");
            deleteEsStrList.forEach(str -> {
                System.out.println(str);
            });

            MyFileUtil.pushListToFile(deleteEsStrList, "C:\\Users\\Administrator\\Desktop\\es删除数据.txt");

            System.out.println("\n\n" + deleteEsStrList.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void name() {
        String str = "[{\"id\":null,\"type\":1,\"name\":\"小赖\"},{\"id\":15322,\"type\":1,\"name\":\"邓小俊\"},{\"id\":14202,\"type\":1,\"name\":\"邓文俊\"}]";
        JSONArray array = JSON.parseArray(str);
        if (array.size() > 0) {
            for (int i = 0; i < array.size(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);
                Long userId = jsonObject.getLong("id");
                String name = jsonObject.getString("name");
                Integer type = jsonObject.getInteger("type");
                System.out.println("" + userId + name + type);
            }
        }
        List<String> voList = JSON.parseArray(str, String.class);
        System.out.println(array.size());
    }
}

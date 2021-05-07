package json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mytool.base.utils.MyFileUtil;
import org.apache.lucene.queryparser.classic.QueryParser;
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
    public void escapeTest() {
        //es检索时，出现特殊字符而没有做正确的处理，那么es将无法识别这条检索语句，则会抛出异常，此时就的对检索语句进行转义:
        String title = "title+-&&||!(){}[]^\"~*?:\\";
        title = QueryParser.escape(title);// 主要就是这一句把特殊字符都转义,那么lucene就可以识别
        System.out.println(title);
        String json = "{\n" +
                "    \"query\": {\n" +
                "        \"bool\": {\n" +
                "            \"must\": [\n" +
                "                {\n" +
                "                    \"term\": {\n" +
                "                        \"isShow\": 1\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"term\": {\n" +
                "                        \"status\": 1\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"term\": {\n" +
                "                        \"deleteStatus\": 1\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"term\": {\n" +
                "                        \"companyNo\": \"SJLXXWLYXZRGS-201806\"\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"query_string\": {\n" +
                "                        \"query\": \"玫瑰\",\n" +
                "                        \"fields\": [\n" +
                "                            \"spuName\"\n" +
                "                        ]\n" +
                "                    }\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    },\n" +
                "    \"highlight\": {\n" +
                "        \"pre_tags\": [\n" +
                "            \"<em>\"\n" +
                "        ],\n" +
                "        \"post_tags\": [\n" +
                "            \"</em>\"\n" +
                "        ],\n" +
                "        \"fields\": {\n" +
                "            \"spuName\": {}\n" +
                "        }\n" +
                "    }\n" +
                "}";
        JSONObject jsonObject = JSON.parseObject(json);
        String jsonStr = jsonObject.toJSONString();
        String test = null;
        String test1 = JSON.toJSONString(test);
        List<String> stringList=null;
        for(String a:stringList){
            System.out.println(a);
        }
        System.out.println(jsonStr);
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

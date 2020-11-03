package PayError;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.junit.Test;
import org.springframework.util.Assert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author duankd
 * @ClassName PayError
 * @date 2020-10-30 18:22:11
 */
public class PayErrorTest {

    static String Insert_Sql_Str ="INSERT INTO t_points_record_list (record_id, business_no,order_no,mobile," +
            "points_type, points, goods_name, oper_id,firm_type," +
            "company_no,badge,integral_type,create_time, status,remark)    VALUES (NULL,'#{businessNo}','#{orderNo}',NULL," +
            "'#{pointsType}','#{pointCount}','#{goodsName}','#{operId}'," +
            "'#{firmType}','#{companyNo}','#{badge}','#{integralType}','#{createTime}','#{status}',NULL);";



    static String Update_Sql_Str ="update t_points_order_cafe set pay_time = '#{createTime}', pay_status = '1', order_status = '4', update_time = now(), remark = '房租减免兑换' where delete_status = '1' and order_id = '#{orderNo}' and company_no = 'SJLXXWLYXZRGS-201806' and badge ='#{badge}' and integral_type = '0';";


    @Test
    public void orderTest() {
        String fileName="D:\\工作\\福利100交接信息\\日常需求\\错误支付订单\\common.log";
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            List<String> pointsRecordStrList= new ArrayList<>();
            List<String> insertSqlStrList= new ArrayList<>();
            List<String> updateSqlStrList= new ArrayList<>();
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                System.out.println("line " + line + ": " + tempString);
                String[] s= tempString.split("\t");
                pointsRecordStrList.add(s[s.length-1]);
                line++;
            }
            reader.close();
            pointsRecordStrList.forEach(json->{
                Map<String, String> map = JSONObject.parseObject(
                        //jsonObject.getString("data"),
                        json,
                        new TypeReference<Map<String, String>>() {
                        });
                //System.out.println(map);

                String insertSql=Insert_Sql_Str;
                String updateSql=Update_Sql_Str;

                for(Map.Entry<String, String> entry : map.entrySet()){
                    String mapKey = entry.getKey();
                    String mapValue = entry.getValue();
                    //System.out.println(mapKey+":"+mapValue);
                    if(mapKey.equals("createTime")){
                        String time=convertTimeToString(Long.valueOf(mapValue));
                        insertSql=insertSql.replace("#{"+mapKey+"}", time);
                    }else {
                        insertSql=insertSql.replace("#{"+mapKey+"}", mapValue);
                    }
                }
                insertSqlStrList.add(insertSql);


                for(Map.Entry<String, String> entry : map.entrySet()){
                    String mapKey = entry.getKey();
                    String mapValue = entry.getValue();
                    System.out.println(mapKey+":"+mapValue);
                    if(mapKey.equals("createTime")){
                        String time=convertTimeToString(Long.valueOf(mapValue));
                        updateSql=updateSql.replace("#{"+mapKey+"}", time);
                    }else {
                        updateSql=updateSql.replace("#{"+mapKey+"}", mapValue);
                    }
                }
                updateSqlStrList.add(updateSql);

            });

            System.out.println("\n\n#插入sql");
            insertSqlStrList.forEach(sql->{
                System.out.println(sql);
            });

            System.out.println("\n\n#更新sql");
            updateSqlStrList.forEach(sql->{
                System.out.println(sql);
            });
            System.out.println("\n\n"+insertSqlStrList.size());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }

        }
    }


    /**
     * 将Long类型的时间戳转换成String 类型的时间格式，时间格式为：yyyy-MM-dd HH:mm:ss
     */
    public static String convertTimeToString(Long time){
        Assert.notNull(time, "time is null");
        DateTimeFormatter ftf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return ftf.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault()));
    }


    @Test
    public void strTest() {
        String a="哈师大上课大数据的库哈斯";
        String b =a.substring(0,1);
        System.out.println(a.length()+"-->"+b.length());
    }
}

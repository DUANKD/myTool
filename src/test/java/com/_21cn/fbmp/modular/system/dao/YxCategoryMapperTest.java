package com._21cn.fbmp.modular.system.dao;

import cn.hutool.core.io.FileUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//@RunWith(SpringRunner.class)
public class YxCategoryMapperTest {

    static String Sku_Id_Str = "Sku_Id_Str";
    static String Spu_Id_Str = "Spu_Id_Str";
    static String First_Name_Str = "First_Name_Str";
    static String Second_Name_Str = "Second_Name_Str";
    static String Exclude_Str = "/";

    private static String updateGoodSqlTemp = "update t_yx_goods g set g.is_show=1  where g.sku_id=Sku_Id_Str and g.company_no=\"SJLXXWLYXZRGS-201806\";";
    private static String updateCategorySqlTemp = "update t_yx_category c set c.status =1 where c.spu_id =Spu_Id_Str and c.first_name =\"First_Name_Str\" and c.second_name =\"Second_Name_Str\" and c.company_no=\"SJLXXWLYXZRGS-201806\";";
    private static String updateNullCategorySqlTemp = "update t_yx_category c set c.status =1 where c.spu_id =Spu_Id_Str and c.first_name is null  and c.second_name is null and c.company_no=\"SJLXXWLYXZRGS-201806\";";

    @Test
    public void orderTest() {
        File file = FileUtil.file("C:\\Users\\Administrator\\Desktop\\2020年严选上架产品目录20200807_test.xlsx");
        //File file = MyFileUtil.file("D:\\Windows\\Documents\\工作文档\\2020年严选上架产品目录20200807_test.xlsx");
        ExcelReader reader = ExcelUtil.getReader(file);
        List<Map<String, Object>> readAllMap = reader.readAll();
        List<String> goodSqlList = new ArrayList<>();
        List<String> categorySqlList = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        System.out.println("读取完毕：共 " + readAllMap.size() + " 条");
        readAllMap.forEach(map -> {
            String firstName = map.get("一级类目").toString();
            String secondName = map.get("二级类目").toString();
            String spuId = map.get("商品ID").toString();
            String skuId = map.get("SKUID").toString();
            String goodSql = updateGoodSqlTemp.replace(Sku_Id_Str, skuId);
            String categorySql;
            if ((firstName.equals(Exclude_Str)&&secondName.equals(Exclude_Str))||(StringUtils.isEmpty(firstName) && StringUtils.isEmpty(secondName))) {
                categorySql = updateNullCategorySqlTemp.replace(Spu_Id_Str, spuId);
            } else {
                categorySql = updateCategorySqlTemp.replace(Spu_Id_Str, spuId);
                categorySql = categorySql.replace(First_Name_Str, firstName);
                categorySql = categorySql.replace(Second_Name_Str, secondName);
            }
            goodSqlList.add(goodSql);
            categorySqlList.add(categorySql);
        });
        File goodSqlFile=FileUtil.touch("C:\\Users\\Administrator\\Desktop\\goodSql.txt");
        File categorySqlFile=FileUtil.touch("C:\\Users\\Administrator\\Desktop\\categorySql.txt");
        System.out.println("处理完毕，消耗时间<" + (System.currentTimeMillis() - startTime) + ">ms.");
        System.out.println("\n-----------------------------------------------商品sql------------------------------------------\n");
        /*goodSqlList.forEach(sql -> {
            System.out.println(sql);
        });*/
        FileUtil.writeUtf8Lines(goodSqlList,goodSqlFile);
        System.out.println("\n----------------------------------------商品sql导出完毕,共 " + goodSqlList.size() + " 条 ------------------------------------------\n");
        System.out.println("\n-----------------------------------------------品味sql------------------------------------------\n");
        /*categorySqlList.forEach(sql -> {
            System.out.println(sql);
        });*/
        FileUtil.writeUtf8Lines(categorySqlList,categorySqlFile);
        System.out.println("\n----------------------------------------品味sql导出完毕,共 " + categorySqlList.size() + " 条 ------------------------------------------\n");
    }
}
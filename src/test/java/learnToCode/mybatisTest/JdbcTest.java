package learnToCode.mybatisTest;

import org.junit.Test;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class JdbcTest {

    @Test
    public void test() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        String URL = "jdbc:mysql://localhost:3306/imooc";
        String USER = "liulx";
        String PASSWORD = "123456";
        try {
            //1.加载驱动
            //Class.forName(driverClass)
            //加载MySql驱动
            Class.forName("com.mysql.jdbc.Driver");
            //加载Oracle驱动
            //Class.forName("oracle.jdbc.driver.OracleDriver");
            //2. 获得数据库连接
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            //sql
            String sql = "select * from user where username = ?";
            //3.预编译
            preparedStatement = connection.prepareStatement(sql); //预编译SQL，减少sql执行
            //4.设置参数，第一个参数为sql语句中参数的序号(从1开始)，第二个参数为设置的
            preparedStatement.setString(1, "挽歌");
            //5.向数据库发出sql执行查询，查询出结果集
            rs = preparedStatement.executeQuery();
            //遍历查询结果集
            while (rs.next()) {
                System.out.println(rs.getString("id") + " " + rs.getString("username"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Map<String, String> map = new HashMap();
        map.put("", "");
        String value = map.get("");
        System.out.println(value);

    }
}

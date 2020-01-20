package com.topsail.crm.automatic;

import java.sql.*;

/**
 * @author Steven
 * @date 2020-01-08
 */
public class Test {
    public static void main(String[] args) {
        Connection connect = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            connect = DriverManager.getConnection("jdbc:oracle:thin:@//10.13.3.18:1521/cmpakdev.cs.asiainfo", "base", "123");
            System.out.println(connect);

            //第二种方式：PreStatement
            PreparedStatement preState = connect.prepareStatement("select  * from mp_province");
            resultSet = preState.executeQuery();

            while (resultSet.next()) {
                long id = resultSet.getLong("PROVINCE_ID");
                String name = resultSet.getString("NAME");
                String createTime = resultSet.getString("CREATE_TIME");
                String updateTime = resultSet.getString("UPDATE_TIME");
                int enabled = resultSet.getInt("ENABLED");
                System.out.println("id: " + id + ", name: " + name + ", createTime: " + createTime + ", updateTime: " + updateTime + ", enabled: " + enabled);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //第六步：关闭资源
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connect != null) connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

package cn.oyp.jdbc;

import java.sql.*;

/*
* jdbc原始方法实现查询数据库表记录的操作
* */
public class MybatisJdbcDemo {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //加载数据库驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");

            //通过驱动管理类获取数据库连接
            connection = DriverManager.getConnection("jdbc:mysql:///mybatis?characterEncoding=utf-8", "root", "002133");
            //定义sql语句 ? 表示占位符
            String sql = "select * from user where username=?";
            //获取预处理statement
            preparedStatement = connection.prepareStatement(sql);
            //设置参数  第一个参数为sql语句中参数的序号(从1开始)
            //第二个参数为设置的参数值
            preparedStatement.setString(1,"王五");
            //向数据库发出sql执行查询 查询出结果集
             resultSet = preparedStatement.executeQuery();
             //遍历结果集
            while (resultSet.next()){
                System.out.println(resultSet.getString("id")+""+resultSet.getString("username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //释放资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

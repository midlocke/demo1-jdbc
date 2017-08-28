package config;

import java.sql.*;

/**
 * Created by lichao on 2017/8/25.
 */
public class JDBCConnection {

    private static Connection conn;

    private static Statement st;

    ////加载Oracle数据库驱动
    //Class.forName("oracle.jdbc.driver.OracleDriver");
    //
    ////加载SQL Server数据库驱动
    //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    //
    //加载MySQL 数据库驱动
    //Class.forName("com.mysql.jdbc.Driver");

    /* 获取数据库连接的函数*/
    public static Connection getConnection() {
        Connection con = null;  //创建用于连接数据库的Connection对象
        try {
            Class.forName("com.mysql.jdbc.Driver");// 加载Mysql数据驱动

            con = DriverManager.getConnection(
                    "jdbc:mysql://db01.dev1.fn:3306/rtwx_seckill", "su_rtwx_seckill", "GbF8Ales5F");// 创建数据连接

        } catch (Exception e) {
            System.out.println("数据库连接失败" + e.getMessage());
        }
        return con; //返回所建立的数据库连接
    }

    public static void select(){

        conn = getConnection();

        try {
            String sql = "SELECT * from remind where open_id=0000001";  // 插入数据的sql语句

            st = (Statement) conn.createStatement();    // 创建用于执行静态sql语句的Statement对象

            ResultSet rs = st.executeQuery(sql);  // 执行插入操作的sql语句，并返回插入数据的个数

            System.out.println("最后的查询结果为：");
            while (rs.next()) { // 判断是否还有下一个数据
                // 根据字段名获取相应的值
                String name = rs.getString("activity_id");
                int age = rs.getInt("id");
                String sex = rs.getString("activity_time");
                String address = rs.getString("open_id");

                //输出查到的记录的各个字段的值
                System.out.println(name + " " + age + " " + sex + " " + address);
            }

            conn.close();   //关闭数据库连接

        } catch (SQLException e) {
            System.out.println("查询remind数据失败" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        select();   //插入添加记录
    }
}

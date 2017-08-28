package config;

import java.sql.Connection;
import java.sql.Driver;
import java.util.Properties;

/**
 * Created by lichao on 2017/8/25.
 */
public class DriverDescription {

    //Driver接口中的方法：
    //Connection connect(String url, java.util.Properties info)
    //--创建一个给定url的数据库连接

    //boolean acceptsURL(String url)
    //--查询驱动程序是否认为它可以打开给定url的连接。

    //int getMajorVersion()
    //--获取此驱动程序的主版本号

    //int getMinorVersion()
    //--获取此驱动程序的次版本号

    //DriverPropertyInfo[] getPropertyInfo(String url, java.util.Properties info)
    //--获取驱动程序的可能属性信息

    //boolean jdbcCompliant()
    //--报告此驱动程序是否是一个真正的JDBC compliant驱动程序

    //url信息：http://www.cnblogs.com/weizhxa/p/6519451.html
    //oracle定义的自己的url协议如下：
    //jdbc:oracle:thin:@//<host>:<port>/ServiceName
    //jdbc:oracle:thin:@//<host>:<port>:<SID>

    //mysql
    //jdbc:mysql://<host>:<port>/<database_name>
    //默认端口3306，如果服务器使用默认端口则port可以省略
    //允许添加额外的连接属性jdbc:mysql://<host>:<port>/<database_name>?property1=value1&property2=value2

    //sql server
    //jdbc:sqlserver://<server_name>:<port>
    //默认端口1433，如果服务器使用默认端口则port可以省略

    public static void driverTest(){
        try {
            //1.加载oracle驱动类，并实例化
            Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();

            //2.判定指定的URL oracle驱动能否接受(符合oracle协议规则)
            boolean flag = driver.acceptsURL("jdbc:mysql://db01.dev1.fn:3306/databaseName");
            //标准协议测试
            boolean standardFlag1 = driver.acceptsURL("jdbc:mysql://<host>:<port>/databaseName");
            System.out.println("协议测试："+flag+"\t"+standardFlag1);

            //3.创建真实的数据库连接：
            String  url = "jdbc:mysql://db01.dev1.fn:3306/rtwx_seckill";
            Properties props = new Properties();
            props.put("user", "su_rtwx_seckill");
            props.put("password", "GbF8Ales5F");
            Connection connection = driver.connect(url, props);
            //connection 对象用于数据库交互，代码省略。。。。。

        } catch (Exception e) {
            System.out.println("加载Oracle类失败！");
            e.printStackTrace();
        } finally{

        }
    }

    public static void main(String[] args) {
        driverTest();
    }
}

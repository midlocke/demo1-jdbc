package config;

/**
 * Created by lichao on 2017/8/25.
 */
public class Description {

    //详情见：http://blog.csdn.net/luanlouis/article/details/29850811

    //一般情况下，在应用程序中进行数据库连接，调用JDBC接口，首先要将特定厂商的JDBC驱动实现加载到系统内存中，然后供系统使用。
    //Application-->DriverManager-->JDBC Driver Interface -->MySQL JDBC Driver

    //驱动：就是实现了java.sql.Driver接口的类，不同的数据库的驱动类不同，
    //mysql的驱动类：com.mysql.jdbc.Driver
    //oracle的驱动类：oracle.jdbc.driver.OracleDriver
    //sql server的驱动类：com.microsoft.sqlserver.jdbc.SQLServerDriver

    //通过Class.forName()将对应的驱动类加载到内存中，然后执行内存中的static静态代码段，
    //代码段中，会创建一个驱动Driver的实例，放入DriverManager中，供DriverManager使用。
}

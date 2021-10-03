package JDBC;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connection {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {

        //方式一：
        //Driver driver = new com.mysql.jdbc.Driver();

        //获取driver实现类对象
        Driver driver1 = new com.mysql.cj.jdbc.Driver();
        String url1 = "jdbc:mysql://192.168.50.143:3306/test";

        Properties info1 = new Properties();

        //封装用户名和密码
        info1.setProperty("user","root");
        info1.setProperty("password","Hjq@123456");

        java.sql.Connection conn1 = driver1.connect(url1, info1);

        System.out.println(conn1);




        //方式二：不出现第三方api，有更好的移植性
        //获取driver实现类，使用反射
        Class clazz2 = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver2 = (Driver) clazz2.newInstance();


        //提供需要连接的数据库
        String url2 = "jdbc:mysql://192.168.50.143:3306/test";

        Properties info2 = new Properties();
        info2.setProperty("user","root");
        info2.setProperty("password","Hjq@123456");

        //获取连接
        java.sql.Connection conn2 = driver2.connect(url2, info2);
        System.out.println(conn2);



        //方式三：替换Driver
        Class clazz3 = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver3 = (Driver) clazz3.newInstance();

        //提供基本信息
        String url3 = "jdbc:mysql://192.168.50.143:3306/test";
        String user3 = "root";
        String password3 = "Hjq@123456";

        //注册驱动
        DriverManager.registerDriver(driver3);

        //获取连接
        java.sql.Connection con3 = DriverManager.getConnection(url3, user3, password3);

        System.out.println(con3);




        //方法四：
        String url4 = "jdbc:mysql://192.168.50.143:3306/test";
        String user4 = "root";
        String password4 = "Hjq@123456";

        Class.forName("com.mysql.cj.jdbc.Driver");

        java.sql.Connection conn4 = DriverManager.getConnection(url4, user4, password4);

        System.out.println(conn4);



        //方式五：
        //读取配置文件，实现数据与代码分离
        InputStream is = Connection.class.getClassLoader().getResourceAsStream("jdbc.properties");

        Properties pros = new Properties();
        pros.load(is);

        String user5 = pros.getProperty("user");
        String password5 = pros.getProperty("password");
        String url5 = pros.getProperty("url");
        String driverClass5 = pros.getProperty("driverClass");

        //加载驱动
        Class.forName(driverClass5);

        //获取连接
        java.sql.Connection conn5 = DriverManager.getConnection(url5, user5, password5);

        System.out.println(conn5);
    }
}

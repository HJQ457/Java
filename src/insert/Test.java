package insert;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, ParseException {
        //向customer表添加数据
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");

        Properties pros = new Properties();

        pros.load(is);

        //读取四个基本信息
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        //加载驱动
        Class.forName(driverClass);

        //获取连接
        Connection conn = DriverManager.getConnection(url, user, password);

        System.out.println(conn);

        //预编译sql语句
        String sql = "insert into customers(name,email,birth) values(?,?,?)";//?为占位符

        PreparedStatement ps = conn.prepareStatement(sql);

        //填充占位符
        ps.setString(1,"哪吒");
        ps.setString(2,"nezha@gmail.com");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = sdf.parse("1000-01-01");
        ps.setDate(3,new Date(date.getTime()));

        //执行操作
        ps.execute();

        //资源关闭
        ps.close();
        conn.close();
    }
}

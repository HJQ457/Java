package update;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class exer1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

        Scanner scan = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name = scan.next();
        System.out.println("请输入邮箱：");
        String email = scan.next();
        System.out.println("请输入生日：");
        String birthday = scan.next();

       update(name,email,birthday);
       select(email);

    }

    public static void update(String name, String email, String birthday) throws IOException, SQLException, ClassNotFoundException {
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");

        Properties pros = new Properties();

        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        Class.forName(driverClass);

        Connection conn = DriverManager.getConnection(url, user, password);

        String sql = "insert  into customers(name,email,birth) values(?,?,?) ";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setObject(1,name);
        ps.setObject(2,email);
        ps.setObject(3,birthday);

        //执行操作
        ps.execute();

        conn.close();
        ps.close();
    }

    public static void select(String email) throws IOException, ClassNotFoundException, SQLException {
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");

        Properties pros = new Properties();

        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        Class.forName(driverClass);

        Connection conn = DriverManager.getConnection(url, user, password);

        String sql = "select name from customers where email = ?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setObject(1,email);

        ResultSet resultSet = ps.executeQuery();

        if (resultSet.next()){
            System.out.println("插入成功");
        }else {
            System.out.println("插入失败");
        }

        ps.close();
        conn.close();
        resultSet.close();

    }
}

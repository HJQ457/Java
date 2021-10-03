package general;

import statement.StatementTest;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, ParseException {
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");

        Properties pros = new Properties();

        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        Class.forName(driverClass);

        Connection coon = DriverManager.getConnection(url, user, password);

        //String sql = "insert into customers(name ,email,birth) values(?,?,?)";
        String sql = "update customers set email = ? where id = ?";
        //String sql = "delete from customers where id = ?";

        PreparedStatement ps = coon.prepareStatement(sql);

//        ps.setObject(1,"tom");
//        ps.setObject(2,"tom@gmail.com");
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = simpleDateFormat.parse("1999-06-21");
//        ps.setObject(3,new Date(date.getTime()));


        ps.setObject(1,"tom@163.com");
        ps.setObject(2,25);

        //ps.setObject(1,24);


        ps.execute();

        ps.close();
        coon.close();
    }
}

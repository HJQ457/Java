package update;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class Blob {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        Class.forName(driverClass);

        Connection conn = DriverManager.getConnection(url, user, password);
        String sql = "insert into customers(name,email,birth,photo) values(?,?,?,?) ";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setObject(1,"张宇浩");
        ps.setObject(2,"zhang@qq.com");
        ps.setObject(3,"1992-02-06");
        BufferedInputStream fs = new BufferedInputStream(new FileInputStream(new File("D:\\就业指导\\1.jpg")));
        ps.setBlob(4,fs);

        ps.execute();

        ps.close();
        conn.close();
    }
}

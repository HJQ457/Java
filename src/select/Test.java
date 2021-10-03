package select;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class Test {
    public static void main(String[] args) {

    }
    public static Connection getConnection() throws ClassNotFoundException, SQLException, IOException {
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
        return conn;
    }

    public void closeResource(Connection conn, PreparedStatement ps) throws SQLException {
        ps.execute();
        ps.close();
        conn.close();
    }
}

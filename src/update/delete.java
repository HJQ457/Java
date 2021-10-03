package update;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class delete {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        delete(35);
    }

    public static void delete(int ID) throws IOException, SQLException, ClassNotFoundException {
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        Class.forName(driverClass);

        Connection conn = DriverManager.getConnection(url,user,password);

        String sql = "delete from customers where id = ?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setObject(1,ID);

        boolean execute = ps.execute();

        System.out.println("删除成功");

        ps.close();
        conn.close();
    }
}

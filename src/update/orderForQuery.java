package update;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class orderForQuery {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        //加载驱动
        Class.forName(driverClass);

        //获取连接
        Connection conn = DriverManager.getConnection(url, user, password);

        String sql = "select order_id,order_name,order_date from `order` where order_id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1,1);

        ResultSet rs = ps.executeQuery();

        if (rs.next()){
            int id = (int)rs.getObject(1);
            String name = (String) rs.getObject(2);
            Date date = (Date) rs.getObject(3);

            order order = new order(id, name, date);
            System.out.println(order);
        }

        conn.close();
        ps.close();
        rs.close();
    }
}

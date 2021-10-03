package update;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class select {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要查询的id：");
        int i = scanner.nextInt();

        select(i);
    }

    public static void select(int id) throws IOException, ClassNotFoundException, SQLException {
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        Class.forName(driverClass);

        Connection conn = DriverManager.getConnection(url,user,password);

        String sql = "select id,name,email,birth from customers where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1,id);

        ResultSet resultSet = ps.executeQuery();

        if (resultSet.next()){

            int Id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String email = resultSet.getString(3);
            Date birth = resultSet.getDate(4);

            Object[] data = new Object[]{id,name,email,birth};

            for (int i = 0;i < data.length;i++){
                System.out.print(data[i] + " ");
            }
        }else {
            System.out.println("输入id错误");
        }
    }
}

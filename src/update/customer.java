package update;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class customer {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

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
        Connection conn = DriverManager.getConnection(url,user,password);


        String sql = "select id,name,email,birth from customers where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,1);


        //执行，并返回结果集
        ResultSet resultSet = ps.executeQuery();


        //处理结果集
        if (resultSet.next()){   //判断结果集的下一条是否有数据，如果有返回true，并指针下移，返回false，指针不下移

            //获取各个字段值
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String email = resultSet.getString(3);
            Date birth = resultSet.getDate(4);


            //方式一：
            //System.out.println("id = " + id + ",name = " + name + ",email = " + email + ",birth = " + birth);

            //方式二：
            Object[] data = new Object[]{id,name,email,birth};

            for (int i =0;i < data.length;i++){
                System.out.print(data[i] + " ");
            }

//            for (Object object : data) {
//                System.out.print(object + " ");
//            }


            //关闭资源
            conn.close();
            ps.close();
            resultSet.close();
        }
    }
}

package prac;

import java.sql.*;

public class Basic {
    public static void main(String[] args) {
        try {
            //step 1 register driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            //step 2 connection
            //mysql --host=192.168.10.127 --port=3306 --user=dac99 --password=welcome
            String url ="jdbc:mysql://192.168.10.127:3306/dac99";
            Connection conn = DriverManager.getConnection(url,"dac99","welcome");

            //step 3 make statement
            Statement statement = conn.createStatement();

            //step 4 executr statement
            ResultSet resultSet = statement.executeQuery("select * from dept");
            while (resultSet.next()){
                System.out.println((resultSet.getInt(1)) + "  " + resultSet.getString(2) + "  " + resultSet.getString(3) + "  " + resultSet.getString(4) + "  " + resultSet.getString(5));
                System.out.println("-------------------------------------");
            }


        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}

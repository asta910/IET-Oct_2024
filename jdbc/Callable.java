package prac;

import java.sql.*;

public class Callable {
    public static void main(String[] args) {
        try{
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String url = "jdbc:mysql://192.168.10.127:3306/dac99";
            Connection connection = DriverManager.getConnection(url,"dac99","welcome");
            CallableStatement callableStatement = connection.prepareCall("{call pl1(?,?)}");

            int a = 100;

            callableStatement.setInt(1,a);
            callableStatement.registerOutParameter(2, Types.INTEGER);
            callableStatement.execute();

            int ans = callableStatement.getInt(2);

            System.out.println("Output from stored procedure: " + ans);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}

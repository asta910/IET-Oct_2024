package prac;

import java.sql.*;

public class PreParedStatement {
    public static void main(String[] args) throws SQLException {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String url = "jdbc:mysql://192.168.10.127:3306/dac99";
            Connection con = DriverManager.getConnection(url, "dac99", "welcome");

            PreparedStatement pst = con.prepareStatement("select * from login99");
            ResultSet rs = pst.executeQuery();
            int userNum = 1;
            while (rs.next()){
                System.out.println((userNum++) + "  User_Name : " + rs.getString(1) + ", Password : " + rs.getString(2)+ ", Secret : " + rs.getString(3));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

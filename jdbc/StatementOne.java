package prac;

import java.sql.*;
import java.util.Scanner;

public class StatementOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String url ="jdbc:mysql://192.168.10.127:3306/dac99";
            Connection connection = DriverManager.getConnection(url,"dac99","welcome");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into login99 values(?,?,?)");
            System.out.println("Enter username");
            String un = scanner.next();
            System.out.println("Enter password");
            String pass = scanner.next();
            System.out.println("Enter secret");
            scanner.nextLine();
            String src = scanner.nextLine();

            preparedStatement.setString(1,un);
            preparedStatement.setString(2,pass);
            preparedStatement.setString(3,src);

            int result = preparedStatement.executeUpdate();
            if (result>0){
                System.out.println("Inserted successffuullyy");
            }else{
                System.out.println("Operation failed");
            }

            connection.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}

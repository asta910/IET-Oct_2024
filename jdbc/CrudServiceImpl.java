package jdbc;

import java.sql.*;
import java.util.Scanner;

public class CrudServiceImpl implements CrudService{
    Scanner scanner;
    public CrudServiceImpl(){
        scanner = new Scanner(System.in);
    }

    public void addUser() {
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
                System.out.println("Inserted successfully");
            }else{
                System.out.println("Operation failed");
            }

            connection.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }


    public void showSecret() {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String url = "jdbc:mysql://192.168.10.127:3306/dac99";
            Connection con = DriverManager.getConnection(url, "dac99", "welcome");

            PreparedStatement pst = con.prepareStatement("select * from login99 where username= ? and password=? ");

            System.out.println("Enter username");
            String uName = scanner.next();
            System.out.println("Enter password");
            String pass = scanner.next();


            if (validator(uName) && validator(pass)){
                pst.setString(1,uName);
                pst.setString(2,pass);
                ResultSet rs = pst.executeQuery();
                if (rs.next()){
                    System.out.println("Your Secret : " + rs.getString(3));
                }
            }else{
                System.out.println("Stop playing with us and fooling me stupid humannn...");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean updatePassword() {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String url = "jdbc:mysql://192.168.10.127:3306/dac99";
            Connection con = DriverManager.getConnection(url, "dac99", "welcome");

            PreparedStatement pst = con.prepareStatement("update login99 set password = ? where username= ?");

            System.out.println("Enter username");
            String uName = scanner.next();
            System.out.println("Enter password");
            String pass = scanner.next();
            System.out.println("Enter new password");
            String newPass = scanner.next();
            System.out.println("Confirm new  password");
            String newPass2 = scanner.next();

            if (validator(uName) && validator(pass)){
                if (!newPass.equals(newPass2)){
                    System.out.println("Confirm password not matching to new Password ");
                    return false;
                }
                pst.setString(1,newPass);
                pst.setString(2,uName);
                int rs = pst.executeUpdate();
                if (rs>0) {
                    return true;
                }
            }else{
                System.out.println("Stop playing with us and fooling me stupid humannn...");
                return false;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }


    public boolean deleteUser() {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String url = "jdbc:mysql://192.168.10.127:3306/dac99";
            Connection con = DriverManager.getConnection(url, "dac99", "welcome");

            PreparedStatement pst = con.prepareStatement("delete from login99 where username= ? and password=? ");

            System.out.println("Enter username");
            String uName = scanner.next();
            System.out.println("Enter password");
            String pass = scanner.next();


            if (validator(uName) && validator(pass)){
                pst.setString(1,uName);
                pst.setString(2,pass);
                int rs = pst.executeUpdate();
                if (rs>0) {
                    return true;
                }
            }else{
                System.out.println("Stop playing with us and fooling me stupid humannn...");
                return false;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }


    public void showALl() {
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

    private boolean validator(String s){
        for (char ch : s.toCharArray()){
            if (ch == ' ' || ch == '=' || ch == '\'') return false;
        }
        return true;
    }
}

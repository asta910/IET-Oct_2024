import jdbc.CrudService;
import jdbc.CrudServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CrudService crudService = new CrudServiceImpl();
        int ch = 0;
        while (ch!=5){
            System.out.println("1. Add entry \n2. Show secret \n3. Update password \n4. Delete user \n5. Exit..");
            System.out.print("Enter your choice : ");
            ch = sc.nextInt();
            switch(ch){
                case 1:
                    crudService.addUser();
                    break;
                case 2:
                    crudService.showSecret();
                    break;
                case 3:
                    if(crudService.updatePassword()){
                        System.out.println("Password updated successfully");
                    }else{
                        System.out.println("Operation failed");
                    }
                    break;
                case 4:
                    if(crudService.deleteUser()){
                        System.out.println("User deleted successfully");
                    }else{
                        System.out.println("Operation failed");
                    }
                    break;
                case 6:
                    crudService.showALl();
                    break;
                default:
                    System.out.println("Wrong choice");
                    break;
            }
        }
        System.out.println("Have a good day..");

    }
}
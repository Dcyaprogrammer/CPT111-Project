package xjtlu.cpt111.assignment.quiz;
import java.util.Scanner;



public class Main_interface {
    public static void main(String[] args) {
        LoginFunc loginFunc = new LoginFunc();
        Boolean isvalidLogin = false;


        // Welcome message
        System.out.println("Welcome to the Quiz System!");
        // Choose to login or register
        Scanner scanner = new Scanner(System.in);

        while (!isvalidLogin) {
            
            System.out.print("Please choose to login or register:");
            String choice = scanner.nextLine();
            if (choice.equals("login")) {
                System.out.print("Please enter your user id:");
                String userId = scanner.nextLine();
                System.out.print("Please enter your password:");
                String password = scanner.nextLine();
                isvalidLogin = loginFunc.login(userId, password);
            } else if (choice.equals("register")) {
                loginFunc.register();
                isvalidLogin = false;
            }
        }
    }

}

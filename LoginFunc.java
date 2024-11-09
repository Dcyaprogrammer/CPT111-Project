package xjtlu.cpt111.assignment.quiz;

import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;


import java.util.Scanner;

public class LoginFunc {

    // register
    public static void main(String[] args) {
        LoginFunc loginFunc = new LoginFunc();
        loginFunc.register();
    }
    
    public void register() {
        
        boolean validPassword = false;
        String password = "";   

        // input user id
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your user id");

        // input user name
        String userId = scanner.nextLine();
        System.out.println("Please enter your user name");
        String userName = scanner.nextLine();

        // input password
        while (!validPassword) {
            System.out.println("Please enter your password");
            password = scanner.nextLine();
            System.out.println("Please enter your password again");
            String repeat_password = scanner.nextLine();
            if (password.equals(repeat_password)) {
                validPassword = true;
            } else {
                System.out.println("Two passwords are different, please try again");
            }
        }
        scanner.close();
        System.out.println("Your registration is successful!");

        // write user info to csv file
        String userFilePath = "resources/users.csv";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userFilePath, true))) {
            writer.write(userId + "," + userName + "," + password);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package xjtlu.cpt111.assignment.quiz;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


import java.util.Scanner;

public class LoginFunc {

    // For testing
    public static void main(String[] args) {
        LoginFunc loginFunc = new LoginFunc();
        loginFunc.register();
        // Modify the following line to test different user id and password
        loginFunc.login("kanae", "12345");
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

    public boolean login(String userId, String password) {
        boolean isvalidLogin = false;
        String correct_password = "";

        // read csv file
        String userFilePath = "resources/users.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(userFilePath))) {
            String userInfo;
            while ((userInfo = br.readLine()) != null) {
                String[] values = userInfo.split(",");
                if (values[0].equals(userId)) {
                    isvalidLogin = true;
                    correct_password = values[2];
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!isvalidLogin) {
            System.out.println("User id is not found, if you don't have an account, please register first");
            return isvalidLogin;
        }

        if (password.equals(correct_password)) {
            System.out.println("Login successful!");
            return isvalidLogin;
        } else {
            System.out.println("Password is incorrect, please try again");
            return isvalidLogin;
        }
    }
}

package xyz.fluxinc.login;

import xyz.fluxinc.login.exceptions.LoginFailedException;
import xyz.fluxinc.login.users.HardcodedUserProvider;
import xyz.fluxinc.login.users.User;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LoginHandler handler = new LoginHandler(new HardcodedUserProvider());
        Scanner scanner = new Scanner(System.in);
        User user = null;
        int attempts = 3;
        do {
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
            try {
                user = handler.login(username, password);
            } catch (LoginFailedException e) {
                System.out.println(e.getMessage());
            }
            attempts--;
        } while (user == null && attempts > 0);
        if (user != null) {
            System.out.println("Hello, " + user.getUsername() + "!");
        } else {
            System.out.println("Max attempts reached. Please try again later!");
        }
    }
}

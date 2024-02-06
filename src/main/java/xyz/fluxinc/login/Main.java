package xyz.fluxinc.login;

import xyz.fluxinc.login.exceptions.LoginFailedException;
import xyz.fluxinc.login.users.HardcodedUserProvider;
import xyz.fluxinc.login.users.User;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Initializes the login handler, using the HardcodedUserProvider
        LoginHandler handler = new LoginHandler(new HardcodedUserProvider());

        // Sets up a simple scanner to read input from the command line
        Scanner scanner = new Scanner(System.in);

        User user = null;
        int attempts = 3;
        
        do {
            // Prints the prompt, then uses the scanner to read the input from the user
            System.out.print("Username: ");
            String username = scanner.nextLine();

            System.out.print("Password: ");
            String password = scanner.nextLine();

            // Takes the information we've read in above, attempts to login or prints an error message if fails and reduces attempts
            try {
                user = handler.login(username, password);
            } catch (LoginFailedException e) {
                System.out.println(e.getMessage());
                attempts--;
            }
        } while (user == null && attempts > 0);

        // If we're logged in, print the hello, otherwise tell the user they've run out of attempts
        if (user != null) {
            System.out.println("Hello, " + user.getUsername() + "!");
        } else {
            System.out.println("Max attempts reached. Please try again later!");
        }
    }
}

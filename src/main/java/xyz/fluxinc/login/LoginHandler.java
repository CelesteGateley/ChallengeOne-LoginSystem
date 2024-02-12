package xyz.fluxinc.login;

import xyz.fluxinc.login.exceptions.LoginFailedException;
import xyz.fluxinc.login.users.User;
import xyz.fluxinc.login.providers.UserProvider;

/*
 * In this class, we'll be defining the logic we need to handle logins. Checking if a user exists, if the password matches
 * and returning the user if they login successfully
 */
public class LoginHandler {

    private final UserProvider provider;

    public LoginHandler(UserProvider provider) {
        this.provider = provider;
    }

    public User login(String username, String password) throws LoginFailedException {
        User user = this.provider.getUser(username);
        if (user != null && user.verifyPassword(password)) {
            return user;
        }
        throw new LoginFailedException("A user with those details does not exist");
    }
}

package xyz.fluxinc.login;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import xyz.fluxinc.login.exceptions.LoginFailedException;
import xyz.fluxinc.login.providers.HardcodedUserProvider;
import xyz.fluxinc.login.users.User;
import xyz.fluxinc.login.providers.UserProvider;

import java.util.ArrayList;
import java.util.List;

import static xyz.fluxinc.login.helpers.EncryptionHelper.encrypt;

public class LoginHandlerTest {

    @Test
    public void testUserLogin() {
        LoginHandler handler = new LoginHandler(getUserProvider());
        try {
            User user = handler.login("user", "user");
            Assertions.assertNotNull(user);
        } catch (LoginFailedException e) {
            Assertions.fail("Login failed with correct information");
        }

        try {
            User user = handler.login("user", "asdf");
            Assertions.assertNull(user, "Login succeeded with incorrect information");
        } catch (LoginFailedException e) {
            Assertions.assertTrue(true);
        }
    }

    private UserProvider getUserProvider() {
        List<User> users = new ArrayList<>();
        users.add(new User("user", encrypt("user")));
        return new HardcodedUserProvider(users);
    }
}

package xyz.fluxinc.login.providers;

import xyz.fluxinc.login.users.User;

import java.util.ArrayList;
import java.util.List;

import static xyz.fluxinc.login.helpers.EncryptionHelper.encrypt;

public class HardcodedUserProvider extends UserProvider {

    /*
     * The *final* keyword means that it can't be changed once it is set.
     * For Lists, this means that whilst new items can be added or removed, the whole list cannot be swapped out
     */
    private final List<User> users;

    /*
     * Since we'll just have set users with this provider, we will add them all to the list when we create a new provider
     */
    public HardcodedUserProvider() {
        users = new ArrayList<>();
        users.add(new User("admin", encrypt("admin")));
        users.add(new User("user", encrypt("user")));
        users.add(new User("guest", encrypt("guest")));
    }

    /*
     * We can use this to provide a predefined set of users, for testing as an example
     */
    public HardcodedUserProvider(List<User> users) {
        this.users = users;
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    /*
     * When we're looking for a specific user, the easiest way to do it in this setup is to go through every user
     * and when we find the one we're looking for, then we return it. If we get to the end and still haven't found it
     * then we can assume the user doesn't exist
     */
    @Override
    public User getUser(String username) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }
        return null;
    }
}

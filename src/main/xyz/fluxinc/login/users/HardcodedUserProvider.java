package xyz.fluxinc.login.users;

import java.util.ArrayList;
import java.util.List;

public class HardcodedUserProvider extends UserProvider {

    /*
     * The *final* keyword means that it can't be changed once it is set.
     * For Lists, this means that whilst new items can be added or removed, the whole list cannot be swapped out
     */
    private final List<User> users = new ArrayList<>();

    /*
     * Since we'll just have set users with this provider, we will add them all to the list when we create a new provider
     */
    public HardcodedUserProvider() {
        users.add(new User("admin", "admin"));
        users.add(new User("user", "user"));
        users.add(new User("guest", "guest"));
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

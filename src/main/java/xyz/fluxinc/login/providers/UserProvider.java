package xyz.fluxinc.login.providers;

import xyz.fluxinc.login.users.User;

import java.util.List;

/*
 * This is an *abstract* class.
 *
 * Abstract classes are used to make something that will always be used the same way, but may do different things
 * For this example, the UserProvider will always be used to get a list of all users, but one instance may use a
 * hardcoded list, one could read from a database, another could read from a file.
 *
 * The rest of the code doesn't really care where it's reading from, as long as it can get the list of users
 */
public abstract class UserProvider {

    /**
     * This method will return a big list of all users in the system
     *
     * @return A list of all users known to the system
     */
    public abstract List<User> getUsers();

    /**
     * This method will return a specific user with a given username
     *
     * @param username The username of the requested user
     * @return The requested user, or null if no user with that name exists
     */
    public abstract User getUser(String username);
}

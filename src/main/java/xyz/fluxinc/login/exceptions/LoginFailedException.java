package xyz.fluxinc.login.exceptions;

/*
 * This is a custom error. We can use custom errors to check for if something has gone wrong, in this case, the user
 * couldn't be logged in.
 */
public class LoginFailedException extends Exception {

    /*
     * This constructor is used so we can pass error messages to the exception
     */
    public LoginFailedException(String s) {
        super(s);
    }
}

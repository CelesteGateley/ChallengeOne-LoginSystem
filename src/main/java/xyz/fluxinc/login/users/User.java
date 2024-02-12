package xyz.fluxinc.login.users;

import static xyz.fluxinc.login.helpers.EncryptionHelper.encrypt;
import static xyz.fluxinc.login.helpers.EncryptionHelper.verify;

public class User {

    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void encryptPassword(String password) {
        this.password = encrypt(password);
    }

    public boolean verifyPassword(String password) {
        return verify(password, this.password);
    }
}

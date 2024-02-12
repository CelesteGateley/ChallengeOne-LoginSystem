package xyz.fluxinc.login.helpers;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class EncryptionHelper {

    private static final int BCRYPT_COST = 6;

    public static String encrypt(String encryption) {
        return BCrypt.withDefaults().hashToString(BCRYPT_COST, encryption.toCharArray());
    }

    public static boolean verify(String string, String encrypted) {
        return BCrypt.verifyer().verify(string.toCharArray(), encrypted.toCharArray()).verified;
    }
}

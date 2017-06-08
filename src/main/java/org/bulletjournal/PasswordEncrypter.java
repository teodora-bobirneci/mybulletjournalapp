package org.bulletjournal;

import com.google.common.hash.Hashing;

import java.math.BigInteger;
import java.security.SecureRandom;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @author Teodora Bobirneci
 */
public final class PasswordEncrypter {

    public static String encrypt(String salt, String password) {
        return Hashing.sha512().hashString(salt + password, UTF_8).toString();
    }

    public static String generateRandomSalt() {
        return new BigInteger(130, new SecureRandom()).toString(32);
    }

}

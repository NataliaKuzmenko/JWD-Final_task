package by.epamtc.final_task.service.validation;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Algorithm for hash password
 */
public class HashPassword {
    public static final Logger LOGGER = LogManager.getLogger();
    private static final String ALGORITHM_FOR_HASH = "SHA-512";
    private static final int MAX_LENGTH_PASSWORD = 32;
    private static final int DEFAULT_LENGTH_HASH_PASSWORD = 16;
    private static final String SALT = "0";

    private HashPassword() {
    }

    public static String hash(String password) {
        String hashPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance(ALGORITHM_FOR_HASH);
            byte[] messageDigest = md.digest(password.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            hashPassword = no.toString(DEFAULT_LENGTH_HASH_PASSWORD);
            while (hashPassword.length() < MAX_LENGTH_PASSWORD) {
                hashPassword = SALT.concat(hashPassword);
            }
        } catch (NoSuchAlgorithmException e) {
            LOGGER.log(Level.ERROR, "Algorithm not found", e);
        }
        return hashPassword;
    }

  /*  public static final Logger LOGGER = LogManager.getLogger();

    private static final String ALGORITHM_NAME = "MD5";

    private HashPassword() {
    }

    public static String hashPassword(String password) {
        StringBuilder md5Hex = null;

        try {
            MessageDigest messageDigest = MessageDigest.getInstance(ALGORITHM_NAME);
            messageDigest.reset();
            messageDigest.update(password.getBytes());
            byte[] digest = messageDigest.digest();
            BigInteger bigInt = new BigInteger(1, digest);
            md5Hex = new StringBuilder(bigInt.toString(16));

            while (md5Hex.length() < 32) {
                md5Hex.insert(0, "0");
            }

        } catch (NoSuchAlgorithmException e) {
            LOGGER.log(Level.ERROR, "Algorithm not found", e);
        }
        return md5Hex.toString();
    }*/
}





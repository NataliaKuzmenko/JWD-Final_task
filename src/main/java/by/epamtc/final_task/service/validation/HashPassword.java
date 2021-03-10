package by.epamtc.final_task.service.validation;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashPassword {

    private static final String ALGORITHM_NAME = "MD5";

    private HashPassword() {
    }




    public static String hashPassword(String password) {
        byte[] digest;

        try {
            MessageDigest messageDigest = MessageDigest.getInstance(ALGORITHM_NAME);
            messageDigest.reset();
            messageDigest.update(password.getBytes());
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
           // logger.error("Wrong hash algorithm.");
            return null;
        }

        BigInteger bigInt = new BigInteger(1, digest);
        StringBuilder md5Hex = new StringBuilder(bigInt.toString(16));

        while (md5Hex.length() < 32) {
            md5Hex.insert(0, "0");
        }

        return md5Hex.toString();
    }
}



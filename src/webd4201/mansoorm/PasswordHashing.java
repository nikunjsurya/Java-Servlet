package webd4201.mansoorm;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 *  @author 
 *  @version 1.0 (2022-01-28)
 *   @since 1.0
 *
 *   this class is used to hashed the password in a hexadecimal encode
 */
public class PasswordHashing {

    /**
     * a static method that takes string as arguments and digest the password of string into bytes
     * @param passwordToHash password that needs to be hashed
     * @return a hexadecimal generated password
     * @throws NoSuchAlgorithmException this exception will be thrown when there is no password to be hashed
     */
    static String get_SHA_1_SecurePassword(String passwordToHash) throws NoSuchAlgorithmException {
        String generatedPassword = null;

        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.update(passwordToHash.getBytes());
        byte[] bytesOfGeneratedPassword = md.digest();
        generatedPassword =decToHex(bytesOfGeneratedPassword);
        return generatedPassword;
    }

    /**
     * a private static string method that converts the password to hexadecimal value
     * @param bytes a array of byte to convert into hexadecimal value
     * @return a hexadecimal value
     */
    private static String decToHex(byte[] bytes) {
        String hex = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(String.format("%02x", bytes[i]));
        }
        hex = sb.toString();
        return hex;
    }
}

package PasswordHashing;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class passwordhashing {
    public static void main(String[] args) {
        System.out.println("Hashed password in SHA: "+doHashingSHA("12345678"));
        System.out.println("Hashed password in SHA: "+doHashingSHA("1234567"));
        System.out.println("Hashed password in MD5: "+doHashingMD5("12345678"));
        System.out.println("Hashed password in MD5: "+doHashingMD5("1234567"));

    }

    public static String doHashingSHA(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA");
            messageDigest.update(password.getBytes());
            byte[] resultBytesArray = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : resultBytesArray) {
                sb.append(String.format("%02x", b));
            }
       return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);

        }

    }

    public static String doHashingMD5(String password){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(password.getBytes());
            byte[] resultBytesArray = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : resultBytesArray) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);

        }
    }

}





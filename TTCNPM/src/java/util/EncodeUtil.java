package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EncodeUtil {
    public static String md5Formatter(String password){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            
            byte[] digest = md.digest();
            StringBuilder sb = new StringBuilder();
            
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(EncodeUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}

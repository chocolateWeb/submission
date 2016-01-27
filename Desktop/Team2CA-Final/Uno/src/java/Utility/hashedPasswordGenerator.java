package Utility;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;



/**
 *
 * @author Hariharan
 */
public class hashedPasswordGenerator {
    
    public String  generatehash(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException
    {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
    
        //password = "Harry123";
    
        md.update(password.getBytes("UTF-8")); // Change this to "UTF-16" if needed
        byte[] digest = md.digest();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digest.length; i++) 
        {
         sb.append(Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1));
        }
        System.out.println("Hex format : " + sb.toString());
        
        return sb.toString();
    }
    
     
}

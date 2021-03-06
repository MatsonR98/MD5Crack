import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class md5_hash {
    //Code given by instructor
    public static String md5_hash(String plaintext){
        String md5 = null;
        if(null == plaintext) return null;
        try{
        //Create MessageDigest object for MD5
            MessageDigest digest = MessageDigest.getInstance("MD5");
            
            //Update input string in message digest
            digest.update(plaintext.getBytes(), 0, plaintext.length());

            //Converts message digest value in base 16 (hex)
            md5 = new BigInteger(1, digest.digest()).toString(16);
        } 
        catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return md5;
    }
}

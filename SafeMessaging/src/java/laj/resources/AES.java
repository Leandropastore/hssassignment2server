package laj.resources;

import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AES {

    private static final String ALGORITHM = "AES";
    private Key key;
    private byte[] keyBytes;

    public AES(){
        
        SecureRandom r = new SecureRandom();
        keyBytes = new byte[16];
        r.nextBytes(keyBytes);
        key = new SecretKeySpec(keyBytes, ALGORITHM);
    
    }
    
    public AES(String keyString) throws Exception{
        if(keyString.length()==16){
            key = new SecretKeySpec(keyString.getBytes(), ALGORITHM);
            keyBytes = null;
        }
        else{
            Exception e = new Exception("Wrong key size!");
            throw e;
        }
    }
    
    public byte[] getKey(){
    
        return keyBytes;
        
    }
    
    public byte[] encrypt(String valueToEncrypt) throws Exception {
        
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.ENCRYPT_MODE, key);

        byte[] encrValue = c.doFinal(valueToEncrypt.getBytes("UTF-8"));
        
        return encrValue;
        
    }
    
    public String decrypt(byte[] valueToDecrypt) throws Exception {
        
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.DECRYPT_MODE, key);

        byte[] decrValue = c.doFinal(valueToDecrypt);
        
        return new String(decrValue);
        
    }

}
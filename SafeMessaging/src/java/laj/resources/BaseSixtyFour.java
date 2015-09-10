package laj.resources;


import java.util.Base64;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leandro
 */
public class BaseSixtyFour {
    
    
    public static byte[] encode(byte[] valueToEncode){
    
        byte[] encodedByteValue = Base64.getEncoder().encode(valueToEncode);
        
        return encodedByteValue;
    
    }
    
    public static byte[] decode(byte[] valueToDecode) throws Exception {

        byte[] decodedBytes = Base64.getDecoder().decode(valueToDecode);
        
        return decodedBytes;
    }
    
    public static String encode(String valueToEncode){
    
        byte[] encodedByteValue = Base64.getEncoder().encode(valueToEncode.getBytes());
        
        return new String(encodedByteValue);
    
    }
    
    public static String decode(String valueToDecode) throws Exception {

        byte[] decodedBytes = Base64.getDecoder().decode(valueToDecode.getBytes());
        
        return new String(decodedBytes);
    }
    
}

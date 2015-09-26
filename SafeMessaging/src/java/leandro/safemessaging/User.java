/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leandro.safemessaging;

import leandro.resources.ByteManager;
import leandro.resources.Formatter;

/**
 *
 * @author Leandro
 */
public class User {
    
    private String userName;
    private String phoneNumber;
    byte[] publicKey;

    public User(String userName, String phoneNumber, byte[] publicKey){
    
        this.setPhoneNumber(phoneNumber);
        this.setUserName(userName);
        this.setPublicKey(publicKey);
    
    }

    public byte[] getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(byte[] publicKey) {
        this.publicKey = publicKey;
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = Formatter.formatString(userName);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = Formatter.formatString(phoneNumber);
    }
    
    @Override
    public String toString(){
    
        String string = userName+";"+ByteManager.createString(publicKey)+";"+phoneNumber;
        
        return string;
    
    }
}

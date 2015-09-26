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
public class Pending {
    
    private String userName;
    private byte[] keyBytes;

    public Pending(String userName, byte[] keyBytes){
    
        this.setKeyBytes(keyBytes);
        this.setUserName(userName);
    
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = Formatter.formatString(userName);
    }

    public byte[] getKeyBytes() {
        return keyBytes;
    }

    public void setKeyBytes(byte[] keyBytes) {
        this.keyBytes = keyBytes;
    }
    
    @Override
    public String toString(){
    
        String string = userName+";"+ByteManager.createString(keyBytes);
        
        return string;
    
    }
    
}

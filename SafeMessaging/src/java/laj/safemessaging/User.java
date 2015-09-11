/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laj.safemessaging;

import laj.resources.Formatter;

/**
 *
 * @author Leandro
 */
public class User {
    
    private String userName;
    private String phoneNumber;

    public User(String userName, String phoneNumber){
    
        this.setPhoneNumber(phoneNumber);
        this.setUserName(userName);
    
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
    
        String string = userName+";"+phoneNumber;
        
        return string;
    
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laj.safemessaging;

import java.util.ArrayList;
import laj.lib.LibManager;

/**
 *
 * @author Leandro
 */
public class SafeMessaging {
    
    private ArrayList<User> users;
    private ArrayList<Pending> pendings;
    private ArrayList<Message> messages;
    
    private LibManager libManager;

    public SafeMessaging(){
    
        libManager = new LibManager();
        users = libManager.importUsers();
        pendings = libManager.importPendings();
        messages = libManager.importMessages();
    
    }
    
    public void persistUsers(){
    
        String libString = "";
        for(User u:users)
            libString+=u+"\r\n";
        libManager.createLibrary(libString, "user");
    
    }
    
    public void persistMessages(){
    
        String libString = "";
        for(Message m:messages)
            libString+=m+"\r\n";
        libManager.createLibrary(libString, "message");
    
    }
    
    public void persistPending(){
    
        String libString = "";
        for(Pending p:pendings)
            libString+=p+"\r\n";
        libManager.createLibrary(libString, "pending");
    
    }
    
    public boolean addUser(User user){
    
        if(!userAlreadyExists(user)){
            users.add(user);
            return true;
        }
        else
            return false;
    
    }
    
    public boolean userAlreadyExists(User user){
    
        for(User u:users)
            if(u.getUserName().equals(user.getUserName()))
                return true;
        return false;
    
    }
    
    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Pending> getPendings() {
        return pendings;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }
    
    
    
}

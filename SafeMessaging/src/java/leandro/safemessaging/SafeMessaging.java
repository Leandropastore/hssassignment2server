/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leandro.safemessaging;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import leandro.lib.LibManager;
import leandro.resources.AES;
import leandro.resources.ByteManager;
import leandro.resources.RSA;

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
    
        String libString = ""+users.size()+"\r\n";
        for(User u:users)
            libString+=u+"\r\n";
        libManager.createLibrary(libString, "user");
    
    }
    
    public void persistMessages(){
    
        String libString = ""+messages.size()+"\r\n";
        for(Message m:messages)
            libString+=m+"\r\n";
        libManager.createLibrary(libString, "message");
    
    }
    
    public void persistPendings(){
    
        String libString = ""+pendings.size()+"\r\n";
        for(Pending p:pendings)
            libString+=p+"\r\n";
        libManager.createLibrary(libString, "pending");
    
    }
        
    public void persist(){
    
        this.persistMessages();
        this.persistPendings();
        this.persistUsers();
        
    }
    
    
    public boolean add(User user){
    
        if(!alreadyExists(user)){
            users.add(user);
            return true;
        }
        else
            return false;
    
    }
    
    public boolean add(Pending pending){
    
        if(!alreadyExists(pending)){
            pendings.add(pending);
            return true;
        }
        else
            return false;
    
    }
    
    public boolean alreadyExists(User user){
    
        for(User u:users)
            if(u.getUserName().equals(user.getUserName()))
                return true;
        return false;
    
    }
    
    public boolean alreadyExists(Pending pending){
    
        for(Pending p:pendings)
            if(p.getUserName().equals(pending.getUserName()))
                return true;
        for(User u:users)
            if(u.getUserName().equals(pending.getUserName()))
                return true;
        
        return false;
    
    }
    
    public User searchUserByName(String userName){
    
        for(User u:users)
            if(userName.equals(u.getUserName()))
                return u;
        return null;
    }
    
    public boolean remove(User user){
    
        if(users.remove(user))
            return true;
        else
            return false;
    
    }
    
    public boolean remove(Pending pending){
    
        if(pendings.remove(pending))
            return true;
        else
            return false;
    
    }
    
    public boolean remove(Message message){
    
        if(messages.remove(message))
            return true;
        else
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
    
    public boolean generatePendingAccount(String userName){
    
        AES randomKey = new AES();
        System.out.println(ByteManager.createString(randomKey.getKey()));
        return add(new Pending(userName,randomKey.getKey()));
    
    }
    
    public boolean registerUser(String cipheredRegistration){
    
        Pending p = checkCipheredRegistration(cipheredRegistration);
        AES aes;
        if(p!=null){
            try {
                aes = new AES(p.getKeyBytes());
                String result = aes.decrypt(cipheredRegistration);
                add(libManager.createUser(result));
            } catch (Exception ex) {
                Logger.getLogger(SafeMessaging.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return remove(p);
    
    }
    
    public Pending checkCipheredRegistration(String cipheredRegistration){
    
        String result;
        AES aes;
        for(Pending p:pendings){
            
            try {
                aes = new AES(p.getKeyBytes());
                result = aes.decrypt(cipheredRegistration);
                if(result!=null)
                    for(Pending pe:pendings)
                        if(result.startsWith(pe.getUserName()))
                            return p;
            } catch (Exception ex) {
                Logger.getLogger(SafeMessaging.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        return null;
    
    }
    
    public String getPublicKey(String sender,String receiver){
    
        User uSender = searchUserByName(sender);
        User uReceiver = searchUserByName(receiver);
        
        RSA rsa = new RSA(uSender.getPublicKey(),"public");
        return ByteManager.createString(rsa.encryptWithPublic(uReceiver.toString()));
    
    }

}

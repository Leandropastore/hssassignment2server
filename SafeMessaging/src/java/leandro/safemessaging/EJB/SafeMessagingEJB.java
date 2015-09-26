/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leandro.safemessaging.EJB;


import javax.ejb.Stateless;
import leandro.safemessaging.SafeMessaging;

/**
 *
 * @author Leandro
 */
@Stateless
public class SafeMessagingEJB implements SafeMessagingEJBLocal {
    
    SafeMessaging safeMessaging;
    
    //Called by client only on the first time of contact
    @Override
    public String firstContact(String username) {
        
        safeMessaging = new SafeMessaging();
        if(safeMessaging.generatePendingAccount(username)){
            safeMessaging.persist();
            safeMessaging = null;
            return "A password was sent to you. Please, insert it in your device to complete the registration.";
        }
        else{
            safeMessaging = null;
            return "This username already exists, please try another one.";
        }
    }
    
    //Called by client only on the second time of contact, to register its number and public key
    @Override
    public String registerUser(String cipheredRegistration){
        
        safeMessaging = new SafeMessaging();
        if(safeMessaging.registerUser(cipheredRegistration)){
            safeMessaging.persist();
            safeMessaging = null;
            return "Account successfully registered.";
        }else
            return "Something went wrong. Please, check your key and try again.";
        
    
    }
    
    @Override
    public String getPublicKey(String sender,String receiver){
        
        safeMessaging = new SafeMessaging();
        String response = safeMessaging.getPublicKey(sender, receiver);
        safeMessaging = null;
        return response;
    
    }
    
    /*
    //Called by client to get a list of other users' numbers
    @Override
    public String getNumbers(){
        
        return ;
    
    }
    
    
    
    @Override
    public String sendNormalMessage(){
        
        return ;
    
    }
    
    @Override
    public String sendSecureMessage(){
        
        return ;
    
    }
    
    @Override
    public String sendHashedMessage(){
        
        return ;
    
    }
    
    @Override
    public String sendSecureHashedMessage(){
        
        return ;
    
    }*/

    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}

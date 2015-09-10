/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laj.safemessaging.EJB;


import javax.ejb.Stateless;
import laj.resources.AES;

/**
 *
 * @author Leandro
 */
@Stateless
public class SafeMessagingEJB implements SafeMessagingEJBLocal {
    
    //Called by client only on the first time of contact
    @Override
    public String firstContact(String username) {
        
        AES aes = new AES();
        return "A password was sent to you. Please, insert it in your device to complete the registration.";
    }
    
    //Called by client only on the second time of contact, to register its number and public key
    @Override
    public String registerDevice(){
        
        return ;
    
    }
    
    //
    @Override
    public String getNumbers(){
        
        return ;
    
    }
    
    @Override
    public String getPublicKey(){
        
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
    
    }

    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}

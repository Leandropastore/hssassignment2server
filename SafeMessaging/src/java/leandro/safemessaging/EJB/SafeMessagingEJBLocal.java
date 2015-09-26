/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leandro.safemessaging.EJB;

import javax.ejb.Local;

/**
 *
 * @author Leandro
 */
@Local
public interface SafeMessagingEJBLocal {

    String firstContact(String userName);
    String registerUser(String cipheredRegistration);
    String getPublicKey(String sender,String receiver);/*
    String getNumbers();
    String sendNormalMessage();
    String sendSecureMessage();
    String sendHashedMessage();
    String sendSecureHashedMessage();*/
    
}

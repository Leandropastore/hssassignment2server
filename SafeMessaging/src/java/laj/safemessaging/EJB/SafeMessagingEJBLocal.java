/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laj.safemessaging.EJB;

import javax.ejb.Local;

/**
 *
 * @author Leandro
 */
@Local
public interface SafeMessagingEJBLocal {

    String firstContact(String userName);
    String registerUser(String cipheredRegistration);/*
    String getNumbers();
    String getPublicKey();
    String sendNormalMessage();
    String sendSecureMessage();
    String sendHashedMessage();
    String sendSecureHashedMessage();*/
    
}

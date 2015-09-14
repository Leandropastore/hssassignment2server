/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laj.webservices;

import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import laj.safemessaging.EJB.SafeMessagingEJBLocal;

/**
 *
 * @author Leandro
 */
@WebService(serviceName = "SafeMessagingWebService")
@Stateless()
public class SafeMessagingWebService {
    @EJB
    private SafeMessagingEJBLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "firstContact")
    public String firstContact(@WebParam(name = "userName") String userName) {
        return ejbRef.firstContact(userName);
    }

    @WebMethod(operationName = "registerUser")
    public String registerUser(@WebParam(name = "cipheredRegistration") String cipheredRegistration) {
        return ejbRef.registerUser(cipheredRegistration);
    }
    
}

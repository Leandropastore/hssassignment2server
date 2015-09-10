/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laj.safemessaging;

/**
 *
 * @author Leandro
 */
public class Message {
    
    private String message;
    private String fromUser;
    private String toUser;

    public Message(String toUser, String fromUser, String message){
    
        this.setFromUser(fromUser);
        this.setToUser(toUser);
        this.setMessage(message);
    
    }    

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = formatString(message);
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }
    
    public String formatString(String string){
    
        return string.replaceAll("(\\r|\\n|;)", "");
    
    }
    
    @Override
    public String toString(){
        
        String string = fromUser+";"+toUser+";"+message;
        
        return string;
    
    }
    
}

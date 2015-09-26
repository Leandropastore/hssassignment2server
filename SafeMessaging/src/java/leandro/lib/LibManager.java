package leandro.lib;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import leandro.resources.ByteManager;
import leandro.safemessaging.Message;
import leandro.safemessaging.Pending;
import leandro.safemessaging.User;

/**
 *
 * @author Leandro
 */
public class LibManager {

    private static final String userFileName = "C:\\Users\\Leandro\\Documents\\NetBeansProjects\\hssassignment2server\\SafeMessaging\\src\\java\\leandro\\lib\\Users.txt";
    private static final String pendingFileName = "C:\\Users\\Leandro\\Documents\\NetBeansProjects\\hssassignment2server\\SafeMessaging\\src\\java\\leandro\\lib\\Pending.txt";
    private static final String messageFileName = "C:\\Users\\Leandro\\Documents\\NetBeansProjects\\hssassignment2server\\SafeMessaging\\src\\java\\leandro\\lib\\Message.txt";

    public ArrayList<User> importUsers() {
        
        ArrayList<User> users = new ArrayList<User>();
        try {
            FileReader fileReader = new FileReader(this.userFileName);
            BufferedReader br = new BufferedReader(fileReader);

            int len = new Integer(br.readLine());

            User e;
            for (int i = 0; i < len; i++) {

                //Checks if there is something in the next line
                if ((e = createUser(br.readLine())) != null) {
                    users.add(e);
                }
            }

            br.close();
        } catch (IOException e) {
            System.out.println("IO exception reading " + this.userFileName);
        }
        return users;

    }

    public User createUser(String line) {

        if(line!=null){
            String[] tokens = line.split(";");
            String userName = tokens[0];
            String phoneNumber = tokens[2];
            byte[] publicKey = ByteManager.createBytes(tokens[1]);
            return new User(userName,phoneNumber,publicKey);
        }
        else
            return null;

    }
    
    public ArrayList<Pending> importPendings() {
        
        ArrayList<Pending> pendings = new ArrayList<Pending>();
        try {
            FileReader fileReader = new FileReader(this.pendingFileName);
            BufferedReader br = new BufferedReader(fileReader);

            int len = new Integer(br.readLine());

            Pending e;
            for (int i = 0; i < len; i++) {
                try{              
                    //Checks if there is something in the next line
                    if ((e = createPending(br.readLine())) != null) {
                        pendings.add(e);
                    }
                }catch(UnsupportedEncodingException exc){
                    System.out.println("Encoding format is not supported. \n" + exc);
                }  
            }

            br.close();
        } catch (IOException ex) {
            System.out.println("IO exception reading " + this.pendingFileName);
        }
        return pendings;

    }

    public Pending createPending(String line) throws UnsupportedEncodingException {

        if(line!=null){
            String[] tokens = line.split(";");
            String userName = tokens[0];
            String key = tokens[1];
            return new Pending(userName,ByteManager.createBytes(key));
        }
        else
            return null;

    }

    public ArrayList<Message> importMessages() {
        
        ArrayList<Message> messages = new ArrayList<Message>();
        try {
            FileReader fileReader = new FileReader(this.messageFileName);
            BufferedReader br = new BufferedReader(fileReader);

            int len = new Integer(br.readLine());

            Message e;
            for (int i = 0; i < len; i++) {

                //Checks if there is something in the next line
                if ((e = createMessage(br.readLine())) != null) {
                    messages.add(e);
                }
            }

            br.close();
        } catch (IOException e) {
            System.out.println("IO exception reading " + this.messageFileName);
        }
        return messages;

    }

    public Message createMessage(String line) {

        if(line!=null){
            String[] tokens = line.split(";");
            String toUser = tokens[0];
            String fromUser = tokens[1];
            String message = tokens[2];
            return new Message(toUser,fromUser,message);
        }
        else
            return null;

    }
    
    public void createLibrary(String lib, String libType) {

        File file;
        try {
            if(libType.toLowerCase().equals("pending"))
                file = new File(this.pendingFileName);
            else if(libType.toLowerCase().equals("user"))
                file = new File(this.userFileName);
            else if(libType.toLowerCase().equals("message"))
                file = new File(this.messageFileName);
            else
                file = null;
            
            if(file!=null){
                if (!file.exists()) {
                    file.createNewFile();
                }

                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(lib);
                bw.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laj.lib;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import laj.safemessaging.User;

/**
 *
 * @author Leandro
 */
public class LibManager {

    private static final String userFileName = "";

    

    public void importUsers() {
        
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
        

    }

    private User createUser(String line) {

        String[] tokens = line.split(",");
        String userName = tokens[0];
        String phoneNumber = tokens[1];

        return new User(userName,phoneNumber);
        

    }

    public void createLibrary(String lib) {

        try {

            File file = new File(this.userFileName);

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(lib);
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

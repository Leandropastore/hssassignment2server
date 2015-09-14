package laj.resources;


import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import laj.lib.LibManager;
import laj.safemessaging.Message;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leandro
 */
public class Test {
    public static void main(String[] args) {

        try {
            AES test = new AES("aaaaaaassssdfvcf");
            //System.out.println(new String(test.encrypt("Leandro"),"US-ASCII"));
            //System.out.println(test.decrypt("�7�2	dD�R�3XT�"));
            ByteManager bm = new ByteManager();
            
            byte[] ahaha = test.encrypt("LeandroLeandroLeandroLeandroLeandro");
            //String aha = new String(ahaha,"US-ASCII");
            String ahahaha = bm.createString(ahaha);
            byte[] ahahahaha = bm.createBytes(ahahaha);
            //byte[] ahahaha = aha.getBytes("US-ASCII");
            System.out.println(test.decrypt(ahahahaha));
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}

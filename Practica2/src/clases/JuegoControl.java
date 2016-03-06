/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Fer
 */
public class JuegoControl {

    private boolean regFlag = false;
    private DataAccess da = new DataAccess();
    private Jugador p1 = null;

    public JuegoControl() {

    }

    public boolean getFlag() {
        return regFlag;
    }

    public void setFlag(boolean flag) {
        this.regFlag = flag;
    }

    public void registerUser(String name, String pwd) {
        String input_Parameters = name + "," + pwd;
        da.nuevoJugador(input_Parameters);
    }

    public void getRegisteredUser(String name, String pwd) {
        String enc_pwd = md5(pwd);
        String input_Parameters = name + "," + enc_pwd;
        da.getJugador(input_Parameters);
    }

    public void getRankings(){
        
    }
    public String md5(String input) {
        String md5 = null;
        if (null == input) {
            return null;
        }
        try {
            //Create MessageDigest object for MD5
            MessageDigest digest = MessageDigest.getInstance("MD5");
            //Update input string in message digest
            digest.update(input.getBytes(), 0, input.length());
            //Converts message digest value in base 16 (hex) 
            md5 = new BigInteger(1, digest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            System.err.println(e.toString());
        }
        return md5;
    }
}

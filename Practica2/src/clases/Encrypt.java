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
public class Encrypt {
    private static String encrypted;
    private String input;
    
    public Encrypt(String input){
        this.input=input;
    }
    
    public static String md5(String input){
		
		if(null == input) return null;
		
		try {
			
		//Create MessageDigest object for MD5
		MessageDigest digest = MessageDigest.getInstance("MD5");
		
		//Update input string in message digest
		digest.update(input.getBytes(), 0, input.length());

		//Converts message digest value in base 16 (hex) 
		encrypted = new BigInteger(1, digest.digest()).toString(16);

		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}
		return encrypted;
    }
}

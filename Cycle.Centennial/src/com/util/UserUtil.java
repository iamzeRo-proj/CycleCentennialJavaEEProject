package com.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserUtil {
	public static String conver2MD5(String password){
		try {
		MessageDigest md = MessageDigest.getInstance("MD5");
		
			byte[] array = md.digest(password.getBytes( "UTF-8" ));
			StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < array.length; i++) {
	            sb.append( String.format( "%02x", array[i]));
	        }
	        return sb.toString();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return password;
	}
}

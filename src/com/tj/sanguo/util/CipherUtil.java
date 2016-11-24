package com.tj.sanguo.util;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

public class CipherUtil {
	private static CipherUtil INSTALL = new CipherUtil();	
	private KeyGenerator keyGen;
	private Cipher cipher;
	private Key key;
	private CipherUtil() {
		//通过KeyGenerator形成一个key
		try {
			keyGen = KeyGenerator.getInstance("AES");
			keyGen.init(128);
			key = keyGen.generateKey();

			//获得一个私鈅加密类Cipher，ECB是加密方式，PKCS5Padding是填充方法
			cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
	}
	
	public static byte[] doEncrypt(String source) {
		try {
			return INSTALL.encrypt(source);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static String doDecrype(byte[] source) {
		try {
			return INSTALL.decrype(source);
		} catch (Exception e) {
			return "";
		}
	}
	
	private byte[] encrypt(String source) throws Exception {
		//使用私鈅加密
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] cipherText = cipher.doFinal(source.getBytes("UTF8"));
		return cipherText;
	}
	
	private String decrype(byte[] source) throws Exception {
		cipher.init(Cipher.DECRYPT_MODE,key);
		byte[] newPlainText=cipher.doFinal(source);
		return new String(newPlainText, "UTF8");
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		byte[] temp = INSTALL.encrypt("tjtest");
		String target = INSTALL.decrype(temp);

		System.out.println(target);
	}

}

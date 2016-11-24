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
		//ͨ��KeyGenerator�γ�һ��key
		try {
			keyGen = KeyGenerator.getInstance("AES");
			keyGen.init(128);
			key = keyGen.generateKey();

			//���һ��˽�_������Cipher��ECB�Ǽ��ܷ�ʽ��PKCS5Padding����䷽��
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
		//ʹ��˽�_����
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

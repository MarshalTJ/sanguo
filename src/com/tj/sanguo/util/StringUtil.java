package com.tj.sanguo.util;

public class StringUtil {

	public static String padStart(String string, int minLength, char padChar) {
		if (string == null)
		{
			throw new NullPointerException();
		}
		if(string.length() >= minLength) {
			return string;
		}
		StringBuilder sb = new StringBuilder(minLength);
		for (int i = string.length(); i < minLength; i++) {
			sb.append(padChar);
		}
		sb.append(string);
		return sb.toString();
	}
}

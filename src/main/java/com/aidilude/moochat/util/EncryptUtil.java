package com.aidilude.moochat.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;

public class EncryptUtil {

	public static String MD5(String source) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		String target = Base64.encodeBase64String(md5.digest(source.getBytes()));
		return target;
	}

}
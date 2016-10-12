package com.lab;
import java.io.Closeable;

import com.lab.entities.Customers;

public class Utils {
	public static final String DIVIDER = "%";

	public static void safeClose(Closeable closeable) {
		if (closeable != null) {
			try {
				closeable.close();
			} catch (Exception e) {
			}
		}
	}

	public static Customers parseAuthHeader(byte[] authData) {
		String authString = new String(org.apache.tomcat.util.codec.binary.Base64.decodeBase64(authData));
		String name = authString.substring(0, authString.indexOf(DIVIDER));
		Customers result = new Customers();
		result.setName(name);
		return result;
	}
}

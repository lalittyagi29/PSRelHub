package com.ps.utilty;

public class PSString {

	private static String prefix = "";

	public static String prefixUUID(String model) {
		prefix = "";
		for (int i = 0; i < 3; i++) {
			char ch = model.charAt(i);
			prefix = prefix + ch;
			prefix = prefix.toUpperCase();
		}
		return prefix;
	}

}

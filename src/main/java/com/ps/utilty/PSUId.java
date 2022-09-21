package com.ps.utilty;

import java.util.concurrent.ThreadLocalRandom;

public class PSUId {

	private static String valueOf="";
	
	public static String getUniqueId(String model) {
		int abs = Math.abs(ThreadLocalRandom.current().nextInt());
		valueOf = String.valueOf(abs);
		return PSString.prefixUUID(model) + valueOf;
	}

}

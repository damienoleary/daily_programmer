package com.damienoleary;

class IPV4NetworkUtil {
	public static long prefixToMask(int prefix) {
		long allBitsOn = (long)(Math.pow(2, 32) - 1);
		long bitsOff = (long)(Math.pow(2, 32 - prefix) - 1);
		return allBitsOn - bitsOff;
	}

	public static int maskToPrefix(long mask) {
		long allOn = (long)(Math.pow(2, 32) - 1);
		long diff = allOn - mask + 1;
		int offBits = (int)(Math.log(diff)/Math.log(2));
		return 32 - offBits;
	}

	public static long IPStringToIP(String sIP) {
		String[] octetParts = sIP.split("\\.");

		long ip = 0L;
		for (int i = 0; i < 4; i++) {
			ip = (ip << 8) + Integer.parseInt(octetParts[i]);
		}

		return ip;
	}

	public static String IPToIpString(long ip) {
		StringBuilder sb = new StringBuilder();

		int o4 = (int)(ip % 256L);
		sb.append(o4);
		ip /= 256L;

		int o3 = (int)(ip % 256L);
		sb.insert(0, o3 + ".");
		ip /= 256L;

		int o2 = (int)(ip % 256L);
		sb.insert(0, o2 + ".");
		ip /= 256L;

		int o1 = (int)(ip % 256L);
		sb.insert(0, o1 + ".");

		return sb.toString();
	}
}
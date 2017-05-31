package com.damienoleary;

public class IPV4Network {
	public final long mask;
	public final long ip;

	public static IPV4Network createNew(String net) {
		String[] parts = net.split("/");
		int prefix = Integer.parseInt(parts[1]);
		long mask = IPV4NetworkUtil.prefixToMask(prefix);
		long ip = IPV4NetworkUtil.IPStringToIP(parts[0]);

		return new IPV4Network(ip, mask);
	}

	private IPV4Network(long ip, long mask) {
		this.ip = ip;
		this.mask = mask;
	}

	public IPV4Network superNet(long mask) {
		long newIP = this.ip & mask;
		return new IPV4Network(newIP, mask);
	}

	public String toString() {
		return IPV4NetworkUtil.IPToIpString(this.ip) + "/" + 
				IPV4NetworkUtil.maskToPrefix(this.mask);
	}
}
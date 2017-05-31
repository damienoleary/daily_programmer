package com.damienoleary;

import org.junit.Test;
import org.junit.BeforeClass;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import java.util.Map;
import java.util.HashMap;

public class IPV4NetworkTest {

	private static Map<String, Long> IPS;
	private static Map<Integer, Long> prefixesAndMasks;

	@BeforeClass
	public static void setupClass() {
		IPS = new HashMap<>();
		IPS.put("10.10.10.0", 168430080L);

		prefixesAndMasks = new HashMap<>();
		prefixesAndMasks.put(25, IPV4NetworkUtil.prefixToMask(25));
		prefixesAndMasks.put(24, IPV4NetworkUtil.prefixToMask(24));
	}

	@Test
	public void testCreateNew() {
		IPV4Network net = IPV4Network.createNew("10.10.10.0/25");
		long expectedIP = IPS.get("10.10.10.0");
		long expectedMask = prefixesAndMasks.get(25);

		assertEquals(expectedIP, net.ip);
		assertEquals(expectedMask, net.mask);
	}

    @Test
    public void testSuperNetSameIP() {
    	IPV4Network net = IPV4Network.createNew("10.10.10.0/25");
    	long expectedIP = IPS.get("10.10.10.0");
    	long expectedMask = prefixesAndMasks.get(24);
    	
    	IPV4Network superNet = net.superNet(prefixesAndMasks.get(24));

    	assertEquals(expectedIP, superNet.ip);
    	assertEquals(expectedMask, superNet.mask);
    }

    @Test
    public void testSuperNetDifferentIP() {
    	IPV4Network net = IPV4Network.createNew("10.10.10.128/25");
    	long expectedMask = prefixesAndMasks.get(24);
    	long expectedIP = IPS.get("10.10.10.0");
    	
    	IPV4Network superNet = net.superNet(prefixesAndMasks.get(24));
    	
    	assertEquals(expectedIP, superNet.ip);
    	assertEquals(expectedMask, superNet.mask);
    }
}
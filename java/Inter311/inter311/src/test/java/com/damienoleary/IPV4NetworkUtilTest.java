package com.damienoleary;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class IPV4NetworkUtilTest {

    @Test
    public void testPrefixToMaskWithZeroPrefix() {
    	int prefix = 0;

        long result = IPV4NetworkUtil.prefixToMask(prefix);

        assertEquals(0L, result);
    }

    @Test
    public void testPrefixToMaskWithOnePrefix() {
        int prefix = 1;

        long result = IPV4NetworkUtil.prefixToMask(prefix);

        assertEquals(2147483648L, result);
    }

    @Test
    public void testPrefixToMaskWith32Prefix() {
        int prefix = 32;

        long result = IPV4NetworkUtil.prefixToMask(prefix);

        assertEquals(4294967295L, result);
    }

    @Test
    public void testIPStringToIPLongWithBlankIP() {
        String sIP = "0.0.0.0";

        long ip = IPV4NetworkUtil.IPStringToIP(sIP);

        assertEquals(0, ip);
    }

    @Test
    public void testIPStringToIPLongWithFullIP() {
        String sIP = "255.255.255.255";

        long ip = IPV4NetworkUtil.IPStringToIP(sIP);

        assertEquals(4294967295L, ip);
    }

    @Test
    public void testIPToIPStringWithBlankIP() {
        long ip = 0L;

        String sip = IPV4NetworkUtil.IPToIpString(ip);

        assertEquals("0.0.0.0", sip);
    }

    @Test
    public void testIPToIPStringWithFullIP() {
        long ip = 4294967295L;

        String sip = IPV4NetworkUtil.IPToIpString(ip);

        assertEquals("255.255.255.255", sip);
    }

    @Test
    public void testMaskToPrefixWithEmptyMask() {
        long mask = 0L;

        int prefix = IPV4NetworkUtil.maskToPrefix(mask);

        assertEquals(0, prefix);
    }

    @Test
    public void testMaskToPrefixWithFullMask() {
        long mask = 4294967295L;

        int prefix = IPV4NetworkUtil.maskToPrefix(mask);

        assertEquals(32, prefix);
    }
}
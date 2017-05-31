package com.damienoleary;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class IPV4NetworkComparatorTest {

    @Test
    public void testCompare() {
    	IPV4Network net1 = IPV4Network.createNew("10.10.10.0/24");
    	IPV4Network net2 = IPV4Network.createNew("10.10.10.0/23");

    	IPV4NetworkComparator comparator = new IPV4NetworkComparator();

    	assertTrue(comparator.compare(net1, net2) > 0);
    	assertTrue(comparator.compare(net2, net1) < 0);
    }
}
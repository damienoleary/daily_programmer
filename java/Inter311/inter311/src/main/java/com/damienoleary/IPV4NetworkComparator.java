package com.damienoleary;

import java.io.Serializable;
import java.util.Comparator;

class IPV4NetworkComparator implements Comparator<IPV4Network>, Serializable{
	@Override
	public int compare(IPV4Network netA, IPV4Network netB) {
		return (int)(netA.mask - netB.mask);
	}
}
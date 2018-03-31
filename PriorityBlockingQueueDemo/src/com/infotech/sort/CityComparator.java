package com.infotech.sort;

import java.util.Comparator;

// Comparator class
public class CityComparator implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		return o2.compareTo(o1);
	}
}
package com.clearwater;

import org.apache.commons.lang.StringUtils;

public class Divisible {
	
	public static void main(String[] args) {
		String s = "bbbbbb";
		String t = "bb";
		System.out.println(findMinNumber(s, t));
	}
	
	private static int findMinNumber(String s, String t) {
		int smallest = 0;
		if (s.contains(t) && isSubstring(s,t)) {
			
			smallest = findMinNumber(t, t.substring(0,t.length()/2));
			if (smallest < t.length() && smallest > 0) {
				return smallest;
			} else {
				return t.length();
			}
			
		}
		return -1;
	}

	private static boolean isSubstring(String s, String t) {
		String remaining = StringUtils.remove(s, t);
		if (StringUtils.isEmpty(remaining)) {
			return true;
		}
		return false;
	}

}

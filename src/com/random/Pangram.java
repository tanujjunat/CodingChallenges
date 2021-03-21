package com.random;

public class Pangram {
	
	public static void main(String[] args) {
		String str = "we promptly judged antique ivory buckles for the next prize";
		System.out.println(pangrams(str));
	}

	private static String pangrams(String s) {
		String present = "pangram";
		String allChar = "abcdefghijklmnopqrstuvwxyz";
		for (int i=0;i< allChar.length(); i++) {
			if (!(s.contains(allChar.subSequence(i, i+1).toString().toLowerCase()) || s.contains(allChar.subSequence(i, i+1).toString().toUpperCase()))) {
				present = "not pangram";
				break;
			}
		}
		return present;
	}

}

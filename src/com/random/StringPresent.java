package com.random;

public class StringPresent {
	
	public static void main(String[] args) {
		String str = "rhbaasdndfsdskgbfefdbrsdfhuyatrjtcrtyytktjjt";
		System.out.println(hackerrankInString(str));
	}
	
	public static String hackerrankInString(String s) {
		String hackerrank = "hackerrank";
		char[] hackerrankArray = hackerrank.toCharArray();
		char[] sArray = s.toCharArray();
		String yes = "YES";
		String no = "NO";
		int count = 0;
			for (int i = 0; i<sArray.length; i++) {
				if (i < sArray.length) {
					if (hackerrankArray[count] == sArray[i]) {
						count++;
					}
				} else {
					return no;
				}
			}
			
			if (count == hackerrank.length()) {
				return yes;
			} else {
				return no;
			}		
    }

}

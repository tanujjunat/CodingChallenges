package com.random;

import java.util.HashMap;
import java.util.Map;

public class WeightedUniformString {
	
	public static void main(String[] args) {
		
		int [] queries = {1,3,12,5,9,10};
		System.out.println(weightedUniformStrings("abccddde", queries));
		
	}
	
	private static String[] weightedUniformStrings(String s, int[] queries) {
		Map<Integer, String> weightedStringMap = new HashMap<>();
		String [] ans = new String[queries.length];
		int frequency = 1;
		for (int i=0; i< s.length(); i++) {			
			if ((i != 0) && (s.charAt(i-1) == s.charAt(i))) {
				frequency++;
				weightedStringMap.put(frequency * Integer.valueOf(s.charAt(i)-96), String.valueOf(s.charAt(i)));
			} else {
				frequency = 1;
				weightedStringMap.put(frequency * Integer.valueOf(s.charAt(i)-96), String.valueOf(s.charAt(i)));
			}
			
		}
		for (int i = 0; i <queries.length; i++) {
			if (weightedStringMap.get(queries[i]) != null) {
				ans[i] = "Yes";
			} else {
				ans[i] = "No";
			}
			//System.out.println(ans[i]);
		}
		
		return ans;
    }

}

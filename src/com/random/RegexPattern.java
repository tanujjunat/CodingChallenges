package com.random;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPattern {
	
	
	public static void main(String[] args) {
		
		
		Pattern p = Pattern.compile("[0-9]{2}[^0-9][0-9]{2}[^0-9][0-9]{4}");
 		Matcher m = p.matcher("12/02/1992");
 		boolean match = m.matches();
        
        System.out.format("%s", match);
	}

}

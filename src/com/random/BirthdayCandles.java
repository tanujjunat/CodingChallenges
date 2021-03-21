package com.random;

import java.util.Arrays;
import java.util.List;

public class BirthdayCandles {
	
	public static void main(String[] args) {
		List<Integer> candles = Arrays.asList(3,2,1,3);
		int frequency = 0;
		int maxVal = 0;
        for (Integer candle : candles) {        	
        	if (maxVal < candle) {
    			maxVal = candle;
    			frequency = 1;
    		} else if (maxVal == candle) {
    			frequency++;
    		}
        }
        System.out.println(frequency);
	}

}

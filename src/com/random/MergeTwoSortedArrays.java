package com.random;

import java.util.Arrays;

public class MergeTwoSortedArrays {
	public static void main(String[] args) {
		int [] odd = {1,3,5,17,19,21,23,33,35,37};
		int [] even = {2,4,6,8,30,32};
		Integer [] combined = new Integer[odd.length+even.length];
		for (int i = 0,j=0,k=0; i < odd.length + even.length;i++) {
			if (k >= (even.length) && j < odd.length) {
				combined[i] = odd[j];
				j++;
			} else if (j >= (odd.length) && k < even.length) {
				combined[i] = even[k];
				k++;
			} else if(odd[j] < even[k]) {
				combined[i] = odd[j];
				j++;
			} else {
				combined[i] = even[k];
				k++;
			}
		}
		Arrays.asList(combined).forEach(System.out::println);
	}

}

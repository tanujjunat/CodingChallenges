package com.random;

import java.util.LinkedList;
import java.util.Queue;

public class HighestSubsequence {
	
	public static void main(String[] args) {;
		String[] star = {"A","C","B","C","B","C","C","C","F","F","C","F","F","F","C"};
		int maxCount = 0;
		Queue<String> queue = new LinkedList<>();
			int count = 0;
			int lastFreq = 0;
			for (int j = 0; j < star.length; j++) {
				if (queue.size() < 2 && !queue.contains(star[j])) {
					queue.add(star[j]);
					count++;
				} else if (queue.size() <= 2 && queue.contains(star[j])) {
					if (queue.peek().equals(star[j])) {
						queue.poll();
						queue.add(star[j]);
						lastFreq=0;
					} else {
						lastFreq++;
					}
					count++;
				} else {
					if (maxCount < count) {
						maxCount = count;
					}
					queue.remove();
					count = 2 + lastFreq;;
					queue.add(star[j]);
				}
			}
			if (maxCount < count) {
				maxCount = count;
			}
			System.out.println(queue);
			System.out.println(maxCount);		
	}

}

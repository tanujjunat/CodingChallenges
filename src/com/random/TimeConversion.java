package com.random;

public class TimeConversion {
	
	public static void main(String[] args) {
		String time = "04:59:59PM";
		String newTime = "";
		if (time.endsWith("AM")) {
			newTime = time.substring(0, time.length() - 2);
			String[] timeStr = newTime.split(":");
			Integer st = Integer.parseInt(timeStr[0]);
			if (st == 12) {			
				timeStr[0] = "00";
			}		
			newTime = String.join(":", timeStr);
		} else {
			newTime = time.substring(0, time.length() - 2);
			String[] timeStr = newTime.split(":");
			Integer st = Integer.parseInt(timeStr[0]);
			if (st != 12) {
				st = st+12;
			}
			timeStr[0] = st.toString();
			newTime = String.join(":", timeStr);
		}
		System.out.println(newTime);
	}

}

package questions;

import java.util.Scanner;

public class Q1 {
	public static void longestStreak(String str) {
		int num = 0;
		char mostCommon = str.charAt(0);
		
		for(int i = 0; i < str.length(); i++) {
			int count = 0;
			char letter = Character.MIN_VALUE; // assigns char to empty
			
			if(i != str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
				letter = str.charAt(i);
				for(int j = i; str.charAt(j) == str.charAt(i); j++) {
					count++;
				}
			}
			if(count > num) {
				num = count;
				mostCommon = letter;
			}
		}
		System.out.println(mostCommon + " " + num);
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		longestStreak(str);
	}
}

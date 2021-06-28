package midterm;

import java.util.ArrayList;

public class Practice {
	private static String str = "dude";
	private static String trimString = "  Hello World" ;
	private static ArrayList<String> stringsList = new ArrayList<String>();
	private static String[][] stringsArray = new String[5][5];
	
	public static void main(String[] args) {
		System.out.println(str.substring(0, 3));
		
		for(int i = 0; i < stringsArray.length; i++) {
			for(int j = 0; j < stringsArray[i].length; j++) {
				stringsArray[i][j] = "Yay";
				System.out.print(stringsArray[i][j]);
			}
		}
		
		System.out.print('\n');
		
		for(int i = 0; i < 5; i++) {
			stringsList.add("Woo");
			System.out.print(stringsList.get(0));
		}
		
		System.out.print('\n');
		
		System.out.println(trimString);
		trimString = trimString.trim();
		System.out.println(trimString);
	}
}

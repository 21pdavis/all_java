package snowcalc;

import java.util.Scanner;

public class SnowCalculatorMain {
	private static Scanner scan = new Scanner(System.in);
	private final static int LBSPERCUBICFOOT = 20;
	private static double townSqFootage;
	private static double snowfallInches;
	
	public static void main(String[] args) {
		System.out.println("Square footage of town: ");
		townSqFootage = scan.nextDouble();
		
		System.out.println("Snowfall in Inches: ");
		snowfallInches = scan.nextDouble();
		
		System.out.print("Pounds of snow: ");
		System.out.print(townSqFootage * (snowfallInches / 12) * LBSPERCUBICFOOT);
	}
}

package mains;

import java.util.Scanner;
import structures.*;

public class Console {
	private static ListQueue<String> queue = new ListQueue<String>();
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Input 1:");
		queue.enqueue(scan.nextLine());
		System.out.println("Input 2:");
		queue.enqueue(scan.nextLine());
		System.out.println("Input 3:");
		queue.enqueue(scan.nextLine());
		System.out.println("Input 4:");
		queue.enqueue(scan.nextLine());
		System.out.println("Input 5:");
		queue.enqueue(scan.nextLine());
		
		System.out.println("Output: " + queue.toString());
		
		queue.firstToLast();
		
		System.out.println("Output after first to last operation: " + queue.toString());
	}
}

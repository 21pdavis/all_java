package demo;

import java.util.Iterator;
import java.util.Scanner;

public class MainTest {
	@SuppressWarnings("unchecked")
	public static void main(String [] args) {
		Scanner scan = new Scanner(System.in);
		MyLinkedList<String> list = new MyLinkedList<String>();
		
		System.out.println("Input 1:");
		String s1 = scan.nextLine();
		System.out.println("Input 2:");
		String s2 = scan.nextLine();
		System.out.println("Input 3:");
		String s3 = scan.nextLine();
		
		MyLinkedList.printList(list);
		
		list = MyLinkedList.insert(list, s1);
		list = MyLinkedList.insert(list, s2);
		list = MyLinkedList.insert(list, s3);
		
		MyIterator<String> it = list.iterator();
		
		it.add("D");
		
		System.out.println(MyLinkedList.printList(list));
	}
}

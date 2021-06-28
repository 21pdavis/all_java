package sample;
import java.util.Scanner;;

public class Interface {

	
	public static void main(String[] args) {
		Student testStudent = new Student();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Name: ");
		testStudent.setName(scanner.nextLine());
		
		System.out.println("Test score 1: ");
		testStudent.setTest1(scanner.nextInt());
		
		System.out.println("Test score 2: ");
		testStudent.setTest2(scanner.nextInt());
		
		System.out.println("Test score 3: ");
		testStudent.setTest3(scanner.nextInt());
		
		System.out.println('\n' + "Name: " + testStudent.getName());
		System.out.println("Test score 1: " + testStudent.getTest1());
		System.out.println("Test score 2: " + testStudent.getTest2());
		System.out.println("Test score 3: " + testStudent.getTest3());
	}
}

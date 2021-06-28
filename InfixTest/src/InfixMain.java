import java.util.Scanner;

public class InfixMain {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String infix;
		
		System.out.println("Infix expression: ");
		infix = scan.nextLine();
		String postfix = InfixInterpreter.infixToPostfix(infix.trim());
		
		System.out.println(postfix);
	}
}

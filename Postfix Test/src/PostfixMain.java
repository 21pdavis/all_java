import java.util.NoSuchElementException;
import java.util.Scanner;

public class PostfixMain {
	static ListStack<Double> operands = new ListStack<Double>();
	static PostfixEvaluator eval = new PostfixEvaluator(operands);
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Postfix Expression: ");
		String postfix = scan.nextLine();
		try {
			eval.evaluate(postfix.trim());
		} catch (TooManyOperandsException e) {
			System.out.println("Too many operands");
		}
		catch(PostfixFormatException e){
			System.out.println("Format error");
		}
		catch(NoSuchElementException e) {
			System.out.println("Not enough operands");
		}
		System.out.println(operands.toString());
	}
}

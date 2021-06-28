
public class InfixInterpreter {
	final private static char ADD = '+';
	final private static char SUBTRACT = '-';
	final private static char MULTIPLY = '*';
	final private static char DIVIDE = '/';
	final private static char EXPONENT = '^';
	final private static char OPENPARENS = '(';
	final private static char CLOSEDPARENS = ')';

	public static String infixToPostfix(String infix) {
		ListStack<Character> opStack = new ListStack<Character>();
		String postfix = "";
		StringBuilder sb = new StringBuilder(infix);

		/*
		 * Trim out spaces in between characters
		 */
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == ' ') {
				sb.deleteCharAt(i);
			}
		}
		infix = sb.toString();
		
		/*
		 * Beginning of infix --> postfix conversion
		 */
		for (int i = 0; i < infix.length(); i++) {
			//System.out.println(i);
			char currentChar = infix.charAt(i);

			if (isOperator(currentChar)) {
				if (opStack.isEmpty()) {
					opStack.push(currentChar);
				}
				else {
					if(currentChar == OPENPARENS || opStack.peek() == OPENPARENS || isPushable(opStack.peek(), currentChar)) {
						opStack.push(currentChar);
					}
					else {
						while(!opStack.isEmpty() && !isPushable(opStack.peek(), currentChar) && opStack.peek() != OPENPARENS) {
							postfix += opStack.pop();
							postfix += ' ';
						}
						opStack.push(currentChar);
					}
				}
			} else if (currentChar == CLOSEDPARENS) {
				while(opStack.peek() != OPENPARENS) {
					postfix += opStack.pop(); //pop off operators onto postfix string until open parens\
					postfix += ' ';
				}
				opStack.pop(); //pop off open parens (but don't send it anywhere)
			} else {
				postfix += currentChar;
				postfix += ' ';
			}
		}
		while(!opStack.isEmpty()) {
			if(opStack.peek() != OPENPARENS) {
				postfix += opStack.pop();
				postfix += ' ';
			}
		}

		return postfix;
	}

	/*
	 * Returns true if the operator on top of the stack is of a lower precedence
	 * value (less important) than the current operator in traversing the string
	 */
	private static boolean isPushable(char peekOp, char currentChar) {
		int peekOpPrecedence = determinePrecedence(peekOp);
		int currentOpPrecedence = determinePrecedence(currentChar);

		if(peekOp == OPENPARENS)
			return true;
		if (currentOpPrecedence > peekOpPrecedence)
			return true;

		return false;
	}

	private static int determinePrecedence(char op) {
		int precedence = -1;

		
		if (op == EXPONENT) {
			precedence = 2;
		}
		if (op == MULTIPLY || op == DIVIDE) {
			precedence = 1;
		}
		if (op == ADD || op == SUBTRACT) {
			precedence = 0;
		}

		return precedence;
	}

	private static boolean isOperator(char op) {
		if (op == ADD || op == SUBTRACT || op == MULTIPLY || op == DIVIDE || op == EXPONENT || op == OPENPARENS) {
			return true;
		}
		return false;
	}
}

package structures;

/*
 * Paul Davis
 * 12/22/2020
 * Postfix Evaluator Expression
 * This program gets a postfix mathemetical expression as input and returns its double value sum, product, difference, or quotient
 */

public class PostfixEvaluator {
	final private static char ADD = '+';
	final private static char SUBTRACT = '-';
	final private static char MULTIPLY = '*';
	final private static char DIVIDE = '/';
	final private static char EXPONENT = '^';
	private static ListStack<Double> operands = new ListStack<Double>();

	public static double evaluate(String postfix) throws TooManyOperandsException, PostfixFormatException {
		char[] postfixChars = postfix.toCharArray();
		int operandsNum = 0;

		if (isValidPostfixFormat(postfixChars)) {
			for (int i = 0; i < postfixChars.length; i++) {
				char c = postfixChars[i];
				if (Character.isDigit(c)) {
					String num = "";

					for (int j = i; postfixChars[j] != ' '; j++) { // get entire (multi-digit) numbers
						num += postfixChars[j];
						i = j;
					}

					operands.push(Double.parseDouble(num));
					operandsNum++;
				}
				if (c == ADD) {
					double top = operands.pop();
					double bottom = operands.pop();
					operands.push(evalSingleOp(ADD, top, bottom));
				}
				if (c == SUBTRACT) {
					if(i == postfixChars.length - 1) {
						double top = operands.pop();
						double bottom = operands.pop();
						operands.push(evalSingleOp(SUBTRACT, top, bottom));
					}
					else {
						if(!Character.isDigit(postfixChars[i + 1])) {
							double top = operands.pop();
							double bottom = operands.pop();
							operands.push(evalSingleOp(SUBTRACT, top, bottom));
						}
						else {
							String num = "";
							for (int j = i; postfixChars[j] != ' '; j++) { // get entire (multi-digit) numbers
								num += postfixChars[j];
								i = j;
							}

							operands.push(Double.parseDouble(num));
							operandsNum++;
						}
					}
				}
				if (c == MULTIPLY) {
					double top = operands.pop();
					double bottom = operands.pop();
					operands.push(evalSingleOp(MULTIPLY, top, bottom));
				}
				if (c == DIVIDE) {
					double top = operands.pop();
					double bottom = operands.pop();
					operands.push(evalSingleOp(DIVIDE, top, bottom));
				}
				if (c == EXPONENT) {
					double top = operands.pop();
					double bottom = operands.pop();
					operands.push(evalSingleOp(EXPONENT, top, bottom));
				}
			}
		}
		else {
			throw new PostfixFormatException();
		}
		
		if (operands.size() > 1) {
			throw new TooManyOperandsException("Not enough operators for operands count: " + operandsNum);
		}
		
		double rounded = (double) Math.round(operands.peek() * 100) / 100;
		operands.pop();
		operands.push(rounded);
		
		return operands.pop();
	}
	
	private static double evalSingleOp(char operation, double top, double bottom) {
		double result = -1;

		if (operation == ADD) {
			result = bottom + top;
		}
		if (operation == SUBTRACT) {
			result = bottom - top;
		}
		if (operation == MULTIPLY) {
			result = bottom * top;
		}
		if (operation == DIVIDE) {
			result = bottom / top;
		}
		if(operation == EXPONENT) {
			result = Math.pow(bottom, top);
		}

		return result;
	}

	private static boolean isValidPostfixFormat(char[] postfixChars) {
		boolean isValid = true; // start as true then change to false on first error

		for (int i = 0; i < postfixChars.length; i++) {
			char c = postfixChars[i];
			
			if (!Character.isDigit(c) && !isOperator(c) && c != ' ' && c != '.')
				isValid = false;
			if(c == ' ') {
				char nextChar = postfixChars[i + 1];
				
				if(nextChar == ' '){
					isValid = false;
				}
			}
			if(isOperator(c) && i != postfixChars.length - 1) {
				char nextChar = postfixChars[i + 1];
				
				if(isOperator(nextChar)) {
					isValid = false;
				}
			}
		}

		return isValid;
	}

	private static boolean isOperator(char c) {
		if (c == ADD || c == SUBTRACT || c == MULTIPLY || c == DIVIDE || c == EXPONENT)
			return true;
		return false;
	}	
	
	public static void clear() {
		PostfixEvaluator.operands.clear();
	}
}

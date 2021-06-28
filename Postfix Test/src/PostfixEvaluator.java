
public class PostfixEvaluator {
	final char ADD = '+';
	final char SUBTRACT = '-';
	final char MULTIPLY = '*';
	final char DIVIDE = '/';
	ListStack<Double> operands;

	public PostfixEvaluator(ListStack<Double> operands) {
		this.operands = operands;
	}

	public void evaluate(String postfix) throws TooManyOperandsException, PostfixFormatException {
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
			}
		}
		else {
			throw new PostfixFormatException();
		}

		if (operands.size() > 1) {
			throw new TooManyOperandsException("Not enough operators for operands count: " + operandsNum);
		}
	}
	
	private double evalSingleOp(char operation, double top, double bottom) {
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

		return result;
	}

	private boolean isValidPostfixFormat(char[] postfixChars) {
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
		}

		return isValid;
	}

	private boolean isOperator(char c) {
		if (c == ADD || c == SUBTRACT || c == MULTIPLY || c == DIVIDE)
			return true;
		return false;
	}
}

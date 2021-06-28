package structures;

/*
 * Paul Davis
 * 12/22/2020
 * Postfix Evaluator Expression
 * This program gets a postfix mathemetical expression as input and returns its double value sum, product, difference, or quotient
 */

@SuppressWarnings("serial")
public class TooManyOperandsException extends Exception{
	public TooManyOperandsException(String errorMessage) {
		super(errorMessage);
	}
}

package structures;

/*
 * Paul Davis
 * 12/22/2020
 * Postfix Evaluator Expression
 * This program gets a postfix mathemetical expression as input and returns its double value sum, product, difference, or quotient
 */

public interface Stack<E>{
	void push(E element);
	
	E pop();
	
	E peek();
	
	boolean isEmpty();
	
	int size();
	
	String toString();
}

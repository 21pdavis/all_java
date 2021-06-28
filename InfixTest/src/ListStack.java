

/*
 * Paul Davis
 * 12/22/2020
 * Postfix Evaluator Expression
 * This program gets a postfix mathemetical expression as input and returns its double value sum, product, difference, or quotient
 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class ListStack<E> implements Stack<E> {
	int size = 0; 
	public LinkedList<E> stack = new LinkedList<E>();
	
	public ListStack() {
		super();
	}

	public void push(E element) {
		stack.addFirst(element);
		size++;
	}
	
	public E pop() {
		size--;
		return stack.removeFirst();
	}
	
	public E peek() {
		return stack.getFirst();
	}
	
	public boolean isEmpty() {
		boolean isEmpty = false;
		
		try {
			stack.getFirst();
		}
		catch(NoSuchElementException e) {
			isEmpty = true;
		}
		
		return isEmpty;
	}
	
	public int size() {
		return size;
	}
	
	public String toString() {
		String toString = "";
		Iterator<E> it = stack.iterator();
		
		while(it.hasNext()) {
			toString += it.next();
		}
		
		return toString;
	}

	public void clear() {
		stack.clear();
	}
}

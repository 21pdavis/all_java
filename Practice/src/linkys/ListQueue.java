package linkys;

/*
 * Paul Davis
 * 2/5/2021
 * Radix Sort Program
 * This program takes in a list of integers and sorts them using radix sort and an array of queues
 */

import java.util.Stack;

public class ListQueue<T> implements Queue<T> {
	private Stack<T> stack1;
	private Stack<T> stack2;

	public ListQueue() {
		stack1 = new Stack<T>();
		stack2 = new Stack<T>();
	}

	@SuppressWarnings("unchecked")
	public void enqueue(Object element) {
		while (!isEmpty()) {
			stack2.push(stack1.pop());
		}

		stack1.push((T) element);

		while (!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
	}

	@Override
	public T dequeue() {
		return stack1.pop();
	}

	@Override
	public void firstToLast() {
		enqueue(stack1.pop());
	}

	@Override
	public T first() {
		return stack1.peek();
	}

	@Override
	public boolean isEmpty() {
		return stack1.isEmpty();
	}

	@Override
	public int size() {
		return stack1.size();
	}

	@Override
	public String toString() {
		return stack1.toString();
	}
}

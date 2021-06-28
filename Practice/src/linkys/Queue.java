package linkys;

/*
 * Paul Davis
 * 2/5/2021
 * Radix Sort Program
 * This program takes in a list of integers and sorts them using radix sort and an array of queues
 */

public interface Queue<T> {
	public void enqueue(T element);

	public T dequeue();

	public T first();

	public boolean isEmpty();

	public int size();

	public void firstToLast();

	public String toString();
}
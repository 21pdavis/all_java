package structures;

/*
 * Paul Davis
 * 2/26/2021
 * Queue Encryption Program
 * This program takes in a sentence and encryption key, encrypting and/or decrypting the message based on user choice. It used a modified Caesar Cipher that cycles through multiple keys
 */

public interface Queue<T> {
	public void enqueue(T element);

	public T dequeue();

	public T first();

	public boolean isEmpty();

	public int size();

	public void firstToLast();
	
	public void clear();
		
	public String toString();
}
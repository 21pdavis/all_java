package structures;

/*
 * Paul Davis
 * 4/2/2021
 * Binary Tree Program
 * This program takes in integers and sorts them into a balanced binary tree, 
 * allowing the user to input and remove numbers as well as output 
 * inorder, preorder, postorder, and level order traversals
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
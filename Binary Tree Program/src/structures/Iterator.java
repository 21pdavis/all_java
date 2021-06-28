package structures;

/*
 * Paul Davis
 * 4/2/2021
 * Binary Tree Program
 * This program takes in integers and sorts them into a balanced binary tree, 
 * allowing the user to input and remove numbers as well as output 
 * inorder, preorder, postorder, and level order traversals
 */

public interface Iterator<E> {
	// return true if next item in iteration exists
    boolean hasNext();
    
    // return next item in iteration
    E next();
}
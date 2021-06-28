package objects;

/*
 * Paul Davis
 * 12/4/2020
 * Character Database Program
 * Takes in as many characters as the user inputs, then displays the characters in three lists: previous, current, and next characters
 */

import java.util.Iterator;

public interface MyIterator<E> extends Iterator<E> {
	boolean hasNext();

	E next();

	void add(E e);

	void remove();
}

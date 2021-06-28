package objects;

/*
 * Paul Davis
 * 12/4/2020
 * Character Database Program
 * Takes in as many characters as the user inputs, then displays the characters in three lists: previous, current, and next characters
 */

public interface MyListIterator<E> extends MyIterator<E> {
	boolean hasPrev();

	E prev();

	int nextIndex();

	int previousIndex();
}

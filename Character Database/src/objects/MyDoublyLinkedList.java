package objects;

/*
 * Paul Davis
 * 12/4/2020
 * Character Database Program
 * Takes in as many characters as the user inputs, then displays the characters in three lists: previous, current, and next characters
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyDoublyLinkedList<E> implements Iterable<E> {
	Node head;

	public MyDoublyLinkedList() {
		head = null;
	}

	private class Node {
		Object data;
		Node next;
		Node prev;

		Node(Object data) {
			this.data = data;
			next = null;
			prev = null;
		}
	}

	public void insert(Object data) {
		Node newNode = new Node(data);

		if (head == null) {
			head = new Node(data);
		} else {
			Node current = head; // setting current equal to head

			while (current.next != null) { // checking if next value of current node (head) is null
				current = current.next; // when not null,
			}
			newNode.prev = current;
			current.next = newNode;
		}
	}

	public String printList() {
		String s = "";
		Node current = head;

		if (head != null) {
			while (current.next != null) {
				s += current.data + " ";
				current = current.next;
			}
			s += current.data;
		}
		return s;
	}

	public int getSize() {
		int size = 0;
		Node current = head;

		if (head != null) {
			while (current.next != null) {
				size += 1;
				current = current.next;
			}
			size++;
		}

		return size;
	}

	public void clear() {
		head = null;
	}

	private Node getNodeAt(int index) {
		Node current = head;

		if (head != null) {
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
		}

		return current;
	}

	@Override
	public Iterator<E> iterator() {
		return new Itr<E>();
	}

	public MyListIterator<E> listIterator() {
		return new ListItr<E>();
	}

	@SuppressWarnings("hiding")
	public class ListItr<E> extends Itr<E> implements MyListIterator<E> {
		public ListItr() {
			super();
		}

		@SuppressWarnings("unchecked")
		public E prev() {
			if (cursor == 0)
				throw new NoSuchElementException();
			cursor--;
			lastRet--;

			return (E) getNodeAt(cursor).data;
		}

		@Override
		public boolean hasPrev() {
			return lastRet != 0;
		}

		@Override
		public int nextIndex() {
			return cursor;
		}

		@Override
		public int previousIndex() {
			return lastRet;
		}
	}

	@SuppressWarnings("hiding")
	public class Itr<E> implements MyIterator<E> {
		int cursor;
		int size;
		int lastRet;

		public Itr() {
			cursor = 0;
			size = getSize();
			lastRet = -1;
		}

		public boolean hasNext() {
			return cursor != size;
		}

		@SuppressWarnings("unchecked")
		public E next() {
			if (cursor > size)
				throw new NoSuchElementException();
			cursor = cursor + 1;
			lastRet++;

			return (E) getNodeAt(lastRet).data;
		}

		@Override
		public void add(E e) {
			Node newNode = new Node(e);

			if (cursor > 0) {
				Node lastRetNode = getNodeAt(lastRet);

				if (lastRetNode.next != null) {
					newNode.next = lastRetNode.next;
					newNode.prev = lastRetNode;
					lastRetNode.next = newNode;
					lastRetNode.next.next.prev = newNode;
				} else if (lastRetNode.next == null)
					lastRetNode.next = newNode;
			} else {
				newNode.next = head;
				head = newNode;
			}
			size++; // THIS MIGHT CAUSE ERRORS KEEP IN MIND (but it probably won't)
		}

		@Override
		public void remove() {
			if (lastRet < 0)
				throw new IllegalStateException();
			if (size == 1) {
				head = null;
			} else {
				Node lastRetNode = getNodeAt(lastRet);
				if (cursor == size) {
					lastRetNode = null;
				} else if (lastRet == 0) {
					head = lastRetNode.next;
					lastRetNode.next.prev = null;
				} else {
					lastRetNode.prev.next = lastRetNode.next;
					lastRetNode.next.prev = lastRetNode.prev;
					lastRetNode = null;
				}
			}
		}
	}
}
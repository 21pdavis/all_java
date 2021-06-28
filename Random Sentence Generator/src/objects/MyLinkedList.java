package objects;

import java.util.NoSuchElementException;

public class MyLinkedList<E> implements Iterable<E> {
	Node head;

	public MyLinkedList() {
		head = null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static MyLinkedList insert(MyLinkedList list, Object data) {
		Node node = new Node(data);
		node.next = null;

		if (list.head == null) {
			list.head = new Node(data);
		} else {
			Node current = list.head; // setting current equal to head

			while (current.next != null) { // checking if next value of current node (head) is null
				current = current.next; // when not null,
			}
			current.next = new Node(data);
		}

		return list;
	}

	@SuppressWarnings("rawtypes")
	public static String printList(MyLinkedList list) {
		String s = "";
		Node current = list.head;

		if(list.head != null) {
			while (current.next != null) {
				s += current.data + " ";
				current = current.next;
			}
			s += current.data;
		}
		return s;
	}
	
	@SuppressWarnings("rawtypes")
	public static int staticGetSize(MyLinkedList list) {
		int size = 0;
		Node current = list.head;

		if(list.head != null) {
			while (current.next != null) {
				size += 1;
				current = current.next;
			}
			size += 1;
		}
		
		return size;
	}

	private int getSize() {
		int size = 0;
		Node current = head;

		if(head != null) {
			while (current.next != null) {
				size += 1;
				current = current.next;
			}
			size += 1;
		}

		return size;
	}

	public Node getNodeAt(int index) {
		Node current = head;

		if(head != null) {
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
		}

		return current;
	}

	static class Node {
		Object data;
		Node next;

		Node(Object data) {
			this.data = data;
			next = null;
		}
	}

	@Override
	public MyIterator<E> iterator() {
		return new Itr();
	}

	public class Itr implements MyIterator<E> {
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
			int i = cursor;
			if (i > size)
				throw new NoSuchElementException();
			cursor = i + 1;
			lastRet++;

			return (E) getNodeAt(lastRet).data;
		}

		@Override
		public void add(E e) {
			Node newNode = new Node(e);
			Node lastRetNode = getNodeAt(lastRet);

			if (lastRetNode.next != null) {
				newNode.next = lastRetNode.next;
				lastRetNode.next = newNode;
			} else {
				lastRetNode.next = newNode;
			}
		}

		@Override
		public void remove() {
			if (lastRet < 0)
				throw new IllegalStateException();
			if (size == 1) {
				head = null;
			} else {
				if (cursor == size - 1) {
					getNodeAt(lastRet - 1).next = null;
				} else {
					getNodeAt(lastRet - 1).next = getNodeAt(lastRet - 1).next.next;
				}
			}
		}
	}

}

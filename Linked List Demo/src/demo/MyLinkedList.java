package demo;

import java.util.NoSuchElementException;

public class MyLinkedList<E> implements Iterable<E> {
	Node head;
	int size;
	
	public MyLinkedList(){
		head = null;
		size = 0;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	 public static MyLinkedList insert(MyLinkedList list, Object data) {
		Node node = new Node(data);
		node.next = null;
		
		if(list.head == null) {
			list.head = new Node(data);
		}
		else {
			Node current = list.head; // setting current equal to head
			
			while(current.next != null) { // checking if next value of current node (head) is null
				current = current.next; // when not null, 
			}
			current.next = new Node(data);
			list.size++;
		}
		
		return list;
	}
	
	@SuppressWarnings("rawtypes")
	public static int search(MyLinkedList list, Object key) {
		int index;
		
		for (int i = 0; i < list.size; i++) {
			
		}
		
		return -1;
	}
	 
	@SuppressWarnings("rawtypes")
	 public static void printList(MyLinkedList list) {
		 Node current = list.head;
		 
		 if(current != null) {
			 while(current.next != null) {
				  System.out.print(current.data + " ");
				  current = current.next;
			 }
		 }
	}
	
	@SuppressWarnings("rawtypes")
	public static int getSize(MyLinkedList list) {
		int size = 0;
		Node current = list.head;
		
		while(current.next !=  null) {
			size += 1;
			current = current.next;
		}
		size += 1;
		
		return size;
	}
	
	public Node getNodeAt(int index) {
		Node current = head;
		
		for(int i = 0; i < index; i++) {
			current = current.next;
		}
		
		return current;
	}
	
	static class Node {
		Object data;
		Node next;
		
		Node(Object data){
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
		int lastRet;
		
		public Itr() {
			cursor = 0;
			lastRet = -1;
		}

		public boolean hasNext() {
			return cursor != size;
		}

		@SuppressWarnings("unchecked")
		public E next() {
			int i = cursor;
			if(i > size) 
				throw new NoSuchElementException();
			cursor = i + 1;
			lastRet++;
			
			return (E) getNodeAt(lastRet).data;
		}

		@Override
		public void add(E e) {
			Node newNode = new Node(e);
			Node lastRetNode = getNodeAt(lastRet);
			
			if(lastRetNode.next != null) {
				newNode.next = lastRetNode.next;
				lastRetNode.next = newNode;
			}
			else {
				lastRetNode.next = newNode;
			}
		}

		@Override
		public void remove() {
			System.out.println(lastRet);
			if (lastRet < 0)
                throw new IllegalStateException();
			if(cursor == size - 1) {			
				getNodeAt(lastRet - 1).next = null;
			}
			else
				getNodeAt(lastRet - 1).next = getNodeAt(lastRet - 1).next.next;
		}
	}

}

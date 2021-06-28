


import java.util.Iterator;
import java.util.LinkedList;

@SuppressWarnings("serial")
public class ListStack<E> extends LinkedList<E> implements Stack<E> {
	int size = 0; 
	
	public ListStack() {
		super();
	}

	@Override
	public void push(E element) {
		addFirst(element);
		size++;
	}
	
	@Override
	public E pop() {
		size--;
		return removeFirst();
	}
	
	@Override
	public E peek() {
		return getLast();
	}
	
	public boolean isEmpty() {
		return getFirst() != null;
	}
	
	public int size() {
		return size;
	}
	
	public String toString() {
		String toString = "";
		Iterator<E> it = iterator();
		
		while(it.hasNext()) {
			toString += it.next();
		}
		
		return toString;
	}
}

package demo;

import java.util.Iterator;

public interface MyIterator<E> extends Iterator<E>{
	boolean hasNext();
	
	E next();
	
	void add(E e);
	
	void remove();
}

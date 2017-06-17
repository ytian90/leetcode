package design;

import java.util.Iterator;

/**
 * Peeking Iterator
 * @author yutian
 * @since Oct 26, 2015
 */
//Java Iterator interface reference:
//https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
public class PeekingIterator implements Iterator<Integer> {
	
	private Integer next = null;
	private Iterator<Integer> it;

	public static void main(String[] args) {
		
	}
	
	public PeekingIterator(Iterator<Integer> iterator) {
		// initialize any member here.
		this.it = iterator;
		if (it.hasNext())
			next = it.next();
	}
	
	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public boolean hasNext() {
		return next != null;
	}

	@Override
	public Integer next() {
		Integer result = next;
		next = it.hasNext() ? it.next() : null;
		return result;
	}

}

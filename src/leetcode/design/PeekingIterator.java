package leetcode.design;

import java.util.Iterator;

/**
 * 284. Peeking Iterator
 * @author yutian
 * @since Oct 26, 2015
 */
//Java Iterator interface reference:
//https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
public class PeekingIterator implements Iterator<Integer> {

	private Integer next;
	private Iterator<Integer> it;

	public PeekingIterator(Iterator<Integer> iterator) {
		// initialize any member here.
		this.next = null;
		this.it = iterator;
		if (it.hasNext()) {
			this.next = it.next();
		}
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		int res = next;
		next = it.hasNext() ? it.next() : null;
		return res;
	}

	@Override
	public boolean hasNext() {
		return next != null;
	}

}

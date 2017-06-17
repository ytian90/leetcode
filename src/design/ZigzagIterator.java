package design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 281. Zigzag Iterator
 * @author yutian
 * @since Dec 28, 2015
 */
public class ZigzagIterator {
	// Solution 1
	public LinkedList<Iterator> list;
	
	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list = new LinkedList<Iterator>();
        if (!v1.isEmpty()) list.add(v1.iterator());
        if (!v2.isEmpty()) list.add(v2.iterator());
    }

    public int next() {
        Iterator poll = list.remove();
        int res = (int) poll.next();
        if (poll.hasNext()) list.add(poll);
        return res;
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }

	public static void main(String[] args) {
		List<Integer> v1 = new ArrayList<Integer>();
		v1.add(1); v1.add(2);
		List<Integer> v2 = new ArrayList<Integer>();
		v2.add(3); v2.add(4); v2.add(5); v2.add(6);
		
		ZigzagIterator i = new ZigzagIterator(v1, v2);
		while (i.hasNext()) System.out.print(i.next() + " ");
	}

}

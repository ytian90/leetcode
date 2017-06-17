package design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 281 Follow Up: Zigzag Iterator 2
 * 
 * @author yutian
 * @since Jan 19, 2016
 */
public class Zigzagiterator2 {
	
	public static LinkedList<Iterator> list;
	
	public Zigzagiterator2(List<List<Integer>> v) {
		list = new LinkedList<Iterator>();
		for (List<Integer> l: v) {
			if (!l.isEmpty()) list.add(l.iterator());
		}
	}
	
	public static int next() {
		Iterator poll = list.remove();
		int result = (Integer) poll.next();
		if (poll.hasNext()) list.add(poll);
		return result;
	}
	
	public static boolean hasNext() {
		return !list.isEmpty();
	}
	
	public static void main(String[] args) {
		List<List<Integer>> t1 = new ArrayList<List<Integer>>();
		List<Integer> l1 = new ArrayList<>(Arrays.asList(1, 2, 3));
		List<Integer> l2 = new ArrayList<>(Arrays.asList(4, 5, 6, 7));
		List<Integer> l3 = new ArrayList<>(Arrays.asList(8, 9));
		t1.add(l1); t1.add(l2); t1.add(l3); 
		Zigzagiterator2 i = new Zigzagiterator2(t1);
		while (i.hasNext()) System.out.print(i.next() + " ");
	}

}

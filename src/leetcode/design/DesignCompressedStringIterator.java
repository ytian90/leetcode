package leetcode.design;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 604. Design Compressed String Iterator
 * @author ytian
 *
 */
public class DesignCompressedStringIterator {
	
	Queue<int[]> q = new LinkedList<>();
	
	public DesignCompressedStringIterator(String s) {
        int i = 0, n = s.length();
        while (i < n) {
        	int j = i + 1;
        	while (j < n && s.charAt(j) - 'A' < 0) j++;
        	q.add(new int[]{s.charAt(i) - 'A', Integer.parseInt(s.substring(i + 1, j))});
        	i = j;
        }
    }
    
    public char next() {
        if (q.isEmpty()) return ' ';
        int[] top = q.peek();
        if (--top[1] == 0) q.poll();
        return (char) ('A' + top[0]);
    }
    
    public boolean hasNext() {
        return !q.isEmpty();
    }

	public static void main(String[] args) {
		DesignCompressedStringIterator iterator = new DesignCompressedStringIterator("L1e2t1C1o1d1e1");

		System.out.println(iterator.next()); // return 'L'
		System.out.println(iterator.next()); // return 'e'
		System.out.println(iterator.next()); // return 'e'
		System.out.println(iterator.next()); // return 't'
		System.out.println(iterator.next()); // return 'C'
		System.out.println(iterator.next()); // return 'o'
		System.out.println(iterator.next()); // return 'd'
		System.out.println(iterator.hasNext()); // return true
		System.out.println(iterator.next()); // return 'e'
		System.out.println(iterator.hasNext()); // return false
		System.out.println(iterator.next()); // return ' '
	}

}

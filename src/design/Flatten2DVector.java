package design;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 251. Flatten 2D Vector
 */
public class Flatten2DVector {

	int vi, i;
	int[][] v;

	// input change to int[][]
	public Flatten2DVector(int[][] v) {
		this.v = v;
		this.vi = 0;
		this.i = 0;
	}

	public int next() {
		if (hasNext()) {
			int res = v[vi][i];
			i++;
			return res;
		}
		return -1;
	}

	public boolean hasNext() {
		if (vi >= v.length)
			return false;
		if (i >= v[vi].length) {
			i = 0;
			vi++;
			return hasNext();
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] vec2d = new int[][]{
				{1, 2},
				{3},
				{4}
		};

		Flatten2DVector i = new Flatten2DVector(vec2d);
		while (i.hasNext()) System.out.print(i.next() + " ");

//		List<List<Integer>> vec2d = new ArrayList<List<Integer>>();
//		List<Integer> l1 = new ArrayList<>();
//		l1.add(1); l1.add(2);
//		vec2d.add(l1);
//		List<Integer> l2 = new ArrayList<>();
//		l2.add(3);
//		vec2d.add(l2);
//		List<Integer> l3 = new ArrayList<>();
//		l3.add(4); l3.add(5); l3.add(6);
//		vec2d.add(l3);

	}


//	static Queue<Iterator<Integer>> q;
//
//	public Flatten2DVector(List<List<Integer>> vec2d) {
//		q = new LinkedList<>();
//		for (List<Integer> l : vec2d) {
//			if (!l.isEmpty()) {
//				q.add(l.iterator());
//			}
//		}
//	}
//
//	public static int next() {
//		Iterator<Integer> iterator = q.peek();
//		Integer res = iterator.next();
//		if (!iterator.hasNext()) {
//			q.remove();
//		}
//		return res;
//	}
//
//	public static boolean hasNext() {
//		return !q.isEmpty();
//	}

	// follow incr
//	private static Iterator<List<Integer>> i;
//	private static Iterator<Integer> j;
//
//	public Flatten2DVector(List<List<Integer>> vec2d) {
//        i = vec2d.iterator();
//    }
//
//    public static int next() {
//        hasNext();
//        return j.next();
//    }
//
//    public static boolean hasNext() {
//        while ((j == null || !j.hasNext()) && i.hasNext())
//        	j = i.next().iterator();
//        return j != null && j.hasNext();
//    }


}

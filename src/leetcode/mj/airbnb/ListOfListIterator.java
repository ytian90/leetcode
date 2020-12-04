package leetcode.mj.airbnb;

import java.util.*;

/**
 * 3. List of List (2D List) Iterator
 */
public class ListOfListIterator implements Iterator<Integer>{

    private Iterator<List<Integer>> rowIter;
    private Iterator<Integer> colIter;

    public ListOfListIterator(List<List<Integer>> vec2d) {
        rowIter = vec2d.iterator();
        colIter = Collections.emptyIterator();
    }

    @Override
    public boolean hasNext() {
        while ((colIter == null || !colIter.hasNext()) && rowIter.hasNext()) {
            colIter = rowIter.next().iterator();
        }
        return colIter != null && colIter.hasNext();
    }

    @Override
    public Integer next() {
        return colIter.next();
    }

    @Override
    public void remove() {
        while (colIter == null && rowIter.hasNext()) {
            colIter = rowIter.next().iterator();
        }
        if (colIter != null) {
            colIter.remove();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> vec2d = new ArrayList<List<Integer>>();
		List<Integer> l1 = new ArrayList<>(Arrays.asList(1, 2));
		vec2d.add(l1);
		List<Integer> l2 = new ArrayList<>(Arrays.asList(3));
		vec2d.add(l2);

        ListOfListIterator it = new ListOfListIterator(vec2d);
        System.out.println(it.hasNext());
        System.out.println(it.next());
        it.remove();
        System.out.println(it.hasNext());
        System.out.println(it.next());
        it.remove();
        System.out.println(it.hasNext());
    }
}

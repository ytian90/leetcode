package design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Flatten2DVector {
	
	private static Iterator<List<Integer>> i;
	private static Iterator<Integer> j;
	
	public Flatten2DVector(List<List<Integer>> vec2d) {
        i = vec2d.iterator();
    }

    public static int next() {
        hasNext();
        return j.next();
    }

    public static boolean hasNext() {
        while ((j == null || !j.hasNext()) && i.hasNext())
        	j = i.next().iterator();
        return j != null && j.hasNext();
    }

	public static void main(String[] args) {
		List<List<Integer>> vec2d = new ArrayList<List<Integer>>();
		List<Integer> l1 = new ArrayList<>();
		l1.add(1); l1.add(2);
		vec2d.add(l1);
		List<Integer> l2 = new ArrayList<>();
		l2.add(3); 
		vec2d.add(l2);
		List<Integer> l3 = new ArrayList<>();
		l3.add(4); l3.add(5); l3.add(6);
		vec2d.add(l3);
		Flatten2DVector i = new Flatten2DVector(vec2d);
		while (i.hasNext()) System.out.print(i.next() + " ");
	}

}

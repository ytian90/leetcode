package array;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * 729. My Calendar I
 * @author ytian
 *
 */
public class MyCalendar1 {
	
	// use TreeMap
	TreeMap<Integer, Integer> map;
	
	public MyCalendar1() {
        map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer floorKey = map.floorKey(start);
        if (floorKey != null && map.get(floorKey) > start) return false;
        Integer ceilingKey = map.ceilingKey(start);
        if (ceilingKey != null && ceilingKey < end) return false;
        map.put(start, end);
        return true;
    }
    
    // check overlap
    List<int[]> books;
    
    public MyCalendar1(String dummy) {
    		books = new LinkedList<>();
    }
    
    public boolean book2(int start, int end) {
    		for (int[] b : books) {
    			if (Math.max(b[0], start) < Math.min(b[1], end)) return false;
    		}
    		books.add(new int[] {start, end});
    		return true;
    }

	public static void main(String[] args) {
		MyCalendar1 obj = new MyCalendar1();
		System.out.println(obj.book(10, 20));
		System.out.println(obj.book(15, 25));
		System.out.println(obj.book(20, 30));
	}

}

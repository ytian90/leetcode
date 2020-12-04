package leetcode.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 731. My Calendar II
 * @author ytian
 *
 */
public class MyCalendar2 {
	
	// use TreeMap
	TreeMap<Integer, Integer> map;
	public MyCalendar2() {
		map = new TreeMap<Integer, Integer>();
	}
	
	public boolean book(int start, int end) {
		map.put(start, map.getOrDefault(start, 0) + 1);
		map.put(end, map.getOrDefault(end, 0) - 1);
		int booked = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			booked += entry.getValue();
			if (booked == 3) {
				map.put(start, map.get(start) - 1);
				map.put(end, map.get(end) + 1);
				return false;
			}
		}
		return true;
	}
	
	// use overlaps
	List<int[]> books;

	public MyCalendar2(Integer dummy) {
        books = new ArrayList<>();
    }
    
    public boolean book2(int start, int end) {
        MyCalendar overlaps = new MyCalendar();
        for (int[] b : books) {
        		int n = Math.max(b[0], start);
        		int m = Math.min(b[1], end);
        		if (n < m) {
        			if (!overlaps.book(n, m)) return false;
        		}
        }
        books.add(new int[] {start, end});
        return true;
    }
    
    private static class MyCalendar {
    		List<int[]> books = new ArrayList<>();
    		
    		public boolean book(int start, int end) {
    			for (int[] b : books) {
    				if (Math.max(b[0], start) < Math.min(b[1], end))
    					return false;
    			}
    			books.add(new int[] {start, end});
    			return true;
    		}
    }
	
	public static void main(String[] args) {
		MyCalendar2 mc = new MyCalendar2();
		System.out.println(mc.book(10, 20));
		System.out.println(mc.book(50, 60));
		System.out.println(mc.book(10, 40));
		System.out.println(mc.book(5, 15));
		System.out.println(mc.book(5, 10));
		System.out.println(mc.book(25, 55));
	}
}

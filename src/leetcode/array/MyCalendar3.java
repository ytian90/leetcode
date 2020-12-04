package leetcode.array;

import java.util.TreeMap;

/**
 * 732. My Calendar 3
 * @author ytian
 *
 */
public class MyCalendar3 {
	
	TreeMap<Integer, Integer> map;

	public MyCalendar3() {
        map = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1); // 1 new event will start
        map.put(end, map.getOrDefault(end, 0) - 1); // 1 new event will end
        int curr = 0, max = 0;
        for (int v : map.values()) {
        		curr += v;
        		max = Math.max(max, curr);
        }
        return max;
    }

    public int cancel(int start, int end) {
		map.put(start, map.getOrDefault(start, 0) - 1); // 1 new event will start
		map.put(end, map.getOrDefault(end, 0) + 1); // 1 new event will end
		int curr = 0, max = 0;
		for (int v : map.values()) {
			curr += v;
			max = Math.max(max, curr);
		}
		return max;
	}
	
	public static void main(String[] args) {
		MyCalendar3 mc = new MyCalendar3();
		System.out.println(mc.book(10, 20));
		System.out.println(mc.book(50, 60));
		System.out.println(mc.book(10, 40));
		System.out.println(mc.cancel(10, 40));
		System.out.println(mc.book(10, 40));
		System.out.println(mc.book(5, 15));
		System.out.println(mc.book(5, 10));
		System.out.println(mc.book(25, 55));
	}
}

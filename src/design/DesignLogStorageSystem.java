package design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 635. Design Log Storage System
 * 
 * @author ytian
 *
 */
public class DesignLogStorageSystem {

	private List<String[]> timestamps;
	private List<String> units;
	private int[] indices;

	public DesignLogStorageSystem() {
		this.timestamps = new ArrayList<>();
		this.units = Arrays.asList("Year", "Month", "Day", "Hour", "Minute", "Second");
		this.indices = new int[] { 4, 7, 10, 13, 16, 19 }; // positions of ':' in timestamp
	}

	public void put(int id, String timestamp) {
		timestamps.add(new String[] { Integer.toString(id), timestamp });
	}

	public List<Integer> retrieve(String s, String e, String gra) {
		List<Integer> res = new ArrayList<>();
		int index = indices[units.indexOf(gra)];
		for (String[] t : timestamps) {
			String curr = t[1].substring(0, index);
			String start = s.substring(0, index);
			String end = e.substring(0, index);
			if (curr.compareTo(start) >= 0 && curr.compareTo(end) <= 0) {
				res.add(Integer.parseInt(t[0]));
			}
		}
		return res;
	}

	public static void main(String[] args) {
		DesignLogStorageSystem t = new DesignLogStorageSystem();
		t.put(1, "2017:01:01:23:59:59");
		t.put(2, "2017:01:01:22:59:59");
		t.put(3, "2016:01:01:00:00:00");
		System.out.println(t.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Year"));
		System.out.println(t.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Hour"));
	}

}

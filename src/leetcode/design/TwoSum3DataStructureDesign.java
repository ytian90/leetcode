package leetcode.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 170. Two Sum III - Data Structure Design
 * @author yutian
 * @since Dec 27, 2015
 */
public class TwoSum3DataStructureDesign {
	
	private List<Integer> list = new ArrayList<>();
    private Map<Integer, Integer> map = new HashMap<>();

    // Add the number to an internal data structure.
	public void add(int number) {
	    list.add(number);
	    map.put(number, map.getOrDefault(number, 0) + 1);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for (int i = 0; i < list.size(); i++) {
	        int a = list.get(i);
	        int b = value - a;
	        if ((a == b) && map.get(a) > 1 || (a != b) && map.containsKey(b)) {
	            return true;
	        }
	    }
	    return false;
	}

	public static void main(String[] args) {
		TwoSum3DataStructureDesign n = new TwoSum3DataStructureDesign();
		n.add(1); n.add(2);
		System.out.println(n.find(1));
//		System.out.println(n.find(7));
	}

}

package leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Find all numbers in a given leetcode.array that occur odd number of times
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=164938&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D2%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D5%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
 * @author yutian
 * @since Jan 8, 2016
 */
public class CountOddNumber {
	
	// Solution 1: leetcode.sort Time ~O(nlogn)
	public List<Integer> find(List<Integer> list) {
		List<Integer> result = new ArrayList<>();
		if (list == null || list.size() == 0) return result;
		Collections.sort(list);
		int pre = list.get(0);
		int count = 1;
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) == pre) {
				count++;
			} else {
				if (count % 2 == 1) {
					result.add(pre);
				}
				pre = list.get(i);
				count = 1;
			}
		}
		if (count % 2 == 1) result.add(pre);
		return result;
	}
	
	// Solution 2: hashmap
	public List<Integer> find2(List<Integer> list)  {
		List<Integer> result = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : list) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}
		for (int i: map.keySet()) {
			if (map.get(i) % 2 == 1) {
				result.add(i);
			}
		}
		return result;
	}

	public static void main(String[] args) {

	}

}

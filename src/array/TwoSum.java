package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Two Sum
 * Change to zero-based indices
 * @author yutian
 * @since Sep 4, 2015
 */
public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		// Key -> contents in array, Value -> index
		HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solutions.");
	}
	
	public ArrayList<ArrayList<Integer>> twoSum2(int[] nums, int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length == 0) return result;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i: nums) {
			if (map.containsKey(target - i)) {
				result.add(new ArrayList<Integer>(Arrays.asList(i, target - i)));
				if (map.get(target - i) == 1) {
					map.remove(target - i);
				} else {
					map.put(target - i, map.get(target - i) - 1);
				}
			} else {
				map.put(i, map.containsKey(i) ? map.get(i) + 1: 1);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		TwoSum t = new TwoSum();
		for (ArrayList i: t.twoSum2(new int[]{2, 2, 4, 4}, 6)) {
			System.out.println(i);
		}
	}
	
}

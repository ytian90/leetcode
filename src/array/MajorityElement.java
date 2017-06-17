package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Majority Element
 * @author yutian
 * @since Aug 6, 2015
 */
public class MajorityElement {
	// Solution 1: Sort Time O(NlogN) Space O(N)
	public int majorityElement(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}
	
	// Solution 2: Linear Time Majority Vote Algorithm
	public int majorityElement2(int[] nums) {
		int count = 0, result = 0;
        for (int i : nums) {
            if (count == 0) {
                result = i;
                count++;
            } else if (i == result) {
                count++;
            } else if (i != result) {
                count--;
            }
        }
        return result;
	}
	
	// Solution 3: Hash
	public int majorityElement3(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int result = 0;
		for (int num: nums) {
			if (!map.containsKey(num)) {
				map.put(num, 1);
			} else {
				map.put(num, map.get(num) + 1);
			}
			if (map.get(num) > nums.length / 2) {
				return num;
			}
		}
		return result;
	}
}

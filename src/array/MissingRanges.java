package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 163. Missing Ranges
 * @author yutian
 * @since Jan 16, 2016
 */
public class MissingRanges {
	// Time ~O(N), Space ~O(1)
	public List<String> findMissingRanges2(int[] nums, int lower, int upper) {
		List<String> result = new ArrayList<>();
		// the next number we need to find
		int next = lower;
		for (int n : nums) {
			if (n < next) continue; // not within the range yet
            if (n == next) { // continue to find the next one
                next++;
                continue;
            }
            result.add(getRange(next, n - 1)); // get the missing range string format
            next = n + 1; // now we need to find the next number
		}
		// do a final check
		if (next <= upper) result.add(getRange(next, upper));
		return result;
	}

	String getRange(int i, int j) {
        return (i == j) ? String.valueOf(i) : String.format("%d->%d", i, j);
    }

	public static void main(String[] args) {
		MissingRanges t = new MissingRanges();
		int[] t1 = new int[]{0, 1, 3, 50, 75, 99};
		System.out.print(t.findMissingRanges2(t1, 0, 99));
	}
	
	public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        int pre = lower - 1;
        for (int i = 0; i <= nums.length; i++) {
        	int after = i == nums.length ? upper + 1: nums[i];
        	if (pre + 2 == after) {
        		result.add(String.valueOf(pre + 1));
        	} else if (pre + 2 < after) {
        		result.add(String.valueOf(pre + 1) + "->" + String.valueOf(after - 1));
        	}
        	pre = after;
        }
        return result;
    }

}

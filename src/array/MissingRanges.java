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
	public static List<String> findMissingRanges2(int[] nums, int lower, int upper) {
		List<String> res = new ArrayList<>();
		if (nums.length == 0) {
			res.add(getRange(lower, upper));
			return res;
		}
		if (lower == Integer.MAX_VALUE) {
			return res;
		}
		int i = lower;
		for (int n : nums) {
			if (n < i) continue;
			if (n == i) {
				i++;
				continue;
			}
			res.add(getRange(i, n - 1));
			if (n == upper) return res;
			i = n + 1;
		}
		if (i <= upper) res.add(getRange(i, upper));
		return res;
	}

	private static String getRange(int i, int j) {
        return (i == j) ? String.valueOf(i) : String.format("%d->%d", i, j);
    }

	public static void main(String[] args) {
		System.out.print(findMissingRanges2(new int[]{0, 1, 3, 50, 75, 99}, 0, 99));
		System.out.print(findMissingRanges2(new int[]{2147483647}, 0, 2147483647));
		System.out.print(findMissingRanges2(new int[]{2147483647}, 2147483647, 2147483647));
	}
}

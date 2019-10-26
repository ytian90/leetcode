package sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 179. Largest Number
 * @author yutian
 * @since Aug 16, 2015
 */
public class LargestNumber {
	public static String largestNumber(int[] nums) {
		int n = nums.length;
		String[] s = new String[n];
		for (int i = 0; i < n; i++) {
			s[i] = Integer.toString(nums[i]);
		}
		Arrays.sort(s, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(s[i]);
		}
		if (sb.charAt(0) == '0') {
			return "0";
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(largestNumber(new int[]{3, 30, 34, 5, 9}));
		System.out.println(largestNumber(new int[]{0, 0}));
	}
}

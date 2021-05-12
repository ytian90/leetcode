package leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 179. Largest Number
 * @author yutian
 * @since Aug 16, 2015
 */
public class LargestNumber {
	public static String largestNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return "";
		}
		List<String> strs = new ArrayList<>();
		for (int n : nums) {
			strs.add(String.valueOf(n));
		}
		Collections.sort(strs, (a, b) -> ((b + a).compareTo(a + b)));
		if (strs.get(0).charAt(0) == '0') {
			return "0";
		}
		String res = "";
		for (String s : strs) {
			res += s;
		}
		return res;
	}

	public static String largestNumber1(int[] nums) {
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

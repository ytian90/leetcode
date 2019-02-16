package sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 179. Largest Number
 * @author yutian
 * @since Aug 16, 2015
 */
public class LargestNumber {
	public static Comparator<String> comparator = new Comparator<String>() {
		public int compare(String a, String b) {
			String ab = a + b, ba = b + a;
			for (int i = 0; i < ab.length(); i++) {
				char c1 = ab.charAt(i), c2 = ba.charAt(i);
				if (c1 < c2) return 1;
				else if (c1 > c2) return -1;
			}
			return 0;
		}
	};
	
	public static String largestNumber(int[] nums) {
		int n = nums.length;
		String[] s = new String[n];
		for (int i = 0; i < n; i++) {
			s[i] = Integer.toString(nums[i]);
		}
		Arrays.sort(s, comparator);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(s[i]);
		}
		// delete leading zeros
		int start = 0;
		while (start < n - 1 && sb.charAt(start) == '0') {
			start++;
		}
		return sb.substring(start);
	}

	public static void main(String[] args) {
		System.out.println(largestNumber(new int[]{3, 30, 34, 5, 9}));
		System.out.println(largestNumber(new int[]{0, 0}));
	}
}

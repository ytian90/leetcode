package sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Largest Number
 * @author yutian
 * @since Aug 16, 2015
 */
public class LargestNumber {
	public Comparator<String> comparator = new Comparator<String>() {
		public int compare(String a, String b) {
			String ab = a + b, ba = b + a;
			for (int i = 0; i < ab.length(); i++) {
				char c1 = ab.charAt(i), c2 = ba.charAt(i);
				if (c1 < c2) return -1;
				else if (c1 > c2) return 1;
			}
			return 0;
		}
	};
	
	public String largestNumber(int[] nums) {
		int n = nums.length;
		String[] numStr = new String[n];
		for (int i = 0; i < n; i++) {
			numStr[i] = Integer.toString(nums[i]);
		}
		Arrays.sort(numStr, comparator);
		StringBuilder str = new StringBuilder();
		// append numStr from right to left
		for (int i = n - 1; i >= 0; i--) {
			str.append(numStr[i]);
		}
		// delete leading zeros
		int start = 0;
		while (start < str.length() - 1 && str.charAt(start) == '0') {
			start++;
		}
		return str.substring(start);
	}
}

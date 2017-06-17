package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Summary Ranges
 * @author yutian
 * @since Aug 2, 2015
 */
public class SummaryRanges {
	public static List<String> summaryRanges(int[] nums) {
		List<String> list = new ArrayList<>();
		if (nums == null) return list;
		int i = 0;
		
		for (int j = 1; j < nums.length; j++) {
			if ((long)nums[j] - (long)nums[j - 1] > 1) {
				list.add(getRange(nums[i], nums[j - 1]));
				i = j; // relocate the start point
			}
		}
		
		if (i < nums.length) list.add(getRange(nums[i], nums[nums.length - 1]));
		
		return list;
	}
	public static String getRange(int n1, int n2) {
		return (n1 == n2) ? String.valueOf(n1) : String.format("%d->%d", n1, n2);
	}
	
	public static void main(String[] args) {
		SummaryRanges t = new SummaryRanges();
		System.out.println(summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
		// long
		System.out.println(summaryRanges(new int[]{-2147483648, -2147483647, 2147483647}));
		
		
	}
}

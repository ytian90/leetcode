package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 3Sum
 * @author yutian
 * @since Aug 15, 2015
 */
public class ThreeSum {

	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < nums.length - 2; i = incr(nums, i)) {
			int a = nums[i], lo = i + 1, hi = nums.length - 1;
			while (lo < hi) {
				int b = nums[lo], c = nums[hi];
				if (a + b + c == 0) {
					res.add(Arrays.asList(a, b, c));
					lo = incr(nums, lo);
					hi = decr(nums, hi);
				} else if (a + b + c < 0) {
					lo = incr(nums, lo);
				} else {
					hi = decr(nums, hi);
				}
			}
		}
		return res;
	}

	public static int incr(int[] n, int i) {
		while (i < n.length - 1 && n[i] == n[++i]) {}
		return i;
	}

	public static int decr(int[] n, int i) {
		while (i > 0 && n[i] == n[--i]) {}
		return i;
	}

	public static List<List<Integer>> threeSum2(int[] nums) {
		Arrays.sort(nums);
	    List<List<Integer>> res = new ArrayList<>(); 
	    for (int i = 0; i < nums.length-2; i++) {
	        if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
	            int lo = i + 1, hi = nums.length-1;
	            while (lo < hi) {
	                if (nums[lo] + nums[hi] + nums[i] == 0) {
	                    res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
	                    while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
	                    while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
	                    lo++; hi--;
	                } else if (nums[lo] + nums[hi] + nums[i] < 0) lo++;
	                else hi--;
	           }
	        }
	    }
	    return res;
	}

	// Time ~ O(N^2), Space ~ O(1) 
	public static List<List<Integer>> threeSum1(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> listSet = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length - 2; i = increment(nums, i)) {
			int a = nums[i], low = i + 1, high = nums.length - 1;
			while (low < high) {
				int b = nums[low], c = nums[high];
				if (a + b + c == 0) {
					List<Integer> list = Arrays.asList(a, b, c);
					listSet.add(list);
					low = increment(nums, low);
					high = decrement(nums, high);
				} else if (a + b + c > 0) {
					high = decrement(nums, high);
				} else if (a + b + c < 0) {
					low = increment(nums, low);
				}
			}
		}
		return listSet;
	}
	
	private static int increment(int[] nums, int low) {
		while (low < nums.length - 1 && nums[low] == nums[++low]) { }
		// same as 
//		do { low++; }
//		while (low < nums.length - 1 && nums[low] == nums[low - 1]);
		return low;
	}
	
	private static int decrement(int[] nums, int high) {
		while (high > 0 && nums[high] == nums[--high]) { }
		return high;
	}
	
	public static void main(String[] args) {
		int[] test1 = new int[]{-1, 0, 1, 2, -1, -4};
		List<List<Integer>> result = threeSum(test1);
		for (List<Integer> list: result) {
			System.out.println(list);
		}
		
		int[] test2 = new int[]{-1, -1, 0, 1, 2, -1, -4};
		List<List<Integer>> result2 = threeSum(test2);
		for (List<Integer> list: result2) {
			System.out.println(list);
		}
	}
}

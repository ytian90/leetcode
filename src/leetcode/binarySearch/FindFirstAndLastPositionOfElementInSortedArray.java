package leetcode.binarySearch;

import java.util.Arrays;

/**
 * 34. Search for a Range
 * 
 * @author yutian
 * @since Aug 29, 2015
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

	public static int[] searchRange(int[] nums, int target) {
		if (nums.length == 0) {
			return new int[]{-1, -1};
		}
		int n = nums.length, lo = 0, hi = n - 1, pos = -1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (nums[mid] == target) {
				pos = mid;
				break;
			} else if (nums[mid] < target) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		if (pos == -1) {
			return new int[]{-1, -1};
		}
		lo = pos;
		hi = pos;
		while (lo > 0 && nums[lo - 1] == nums[lo]) {
			lo--;
		}
		while (hi < n - 1 && nums[hi + 1] == nums[hi]) {
			hi++;
		}
		return new int[]{lo, hi};
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(searchRange(new int[] {}, 0)));
		System.out.println(Arrays.toString(searchRange(new int[] {1}, 0)));
		System.out.println(Arrays.toString(searchRange(new int[] {1}, 1)));
		System.out.println(Arrays.toString(searchRange(new int[] {0, 0, 1}, 0)));
		System.out.println(Arrays.toString(searchRange(new int[] {0, 0, 1, 1, 1}, 1)));
		System.out.println(Arrays.toString(searchRange(new int[] {5, 7, 7, 8, 8, 10}, 8)));
		System.out.println(Arrays.toString(searchRange(new int[] {5, 7, 7, 8, 8, 10}, 6)));
	}

	public static int[] searchRange1(int[] nums, int target) {
		int start = helper(nums, target);
		if (start == nums.length || nums[start] != target) {
			return new int[] { -1, -1 };
		}
		return new int[] { start, helper(nums, target + 1) - 1 };
	}

	// Helper function to find the first greater or equal value of target
	public static int helper(int[] a, int target) {
		int lo = 0, hi = a.length; // hi is out of leetcode.array
		while (lo < hi) {
			int mid = lo + ((hi - lo) >> 1);
			if (a[mid] < target) { // if a[mid] == target, hi will decrease to narrow decr
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		return lo;
	}

	public static int[] searchRange2(int[] nums, int target) {
		int[] res = new int[] { -1, -1 };
		if (nums == null || nums.length == 0)
			return res;
		int lo = 0, hi = nums.length - 1;
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			if (nums[mid] < target)
				lo = mid + 1;
			else
				hi = mid;
		}
		if (nums[lo] != target)
			return res;
		else
			res[0] = lo;
		hi = nums.length - 1;
		while (lo < hi) {
			int mid = (lo + hi) / 2 + 1;
			if (nums[mid] > target)
				hi = mid - 1;
			else
				lo = mid;
		}
		res[1] = hi;
		return res;
	}

}

package binarySearch;

import java.util.Arrays;

/**
 * Minimum Size Subarray Sum
 * @author yutian
 * @since Aug 27, 2015
 */
public class MinimumSizeSubarraySum {
	// Solution 1: Two Pointers  Time ~ O(N), Space ~ O(1) 
	public int minSubArrayLen(int s, int[] nums) {
		int prev = 0, sum = 0, res = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			while (sum >= s) { // it should be while!! NOT IF
				res = Math.min(res, i - prev + 1);
				sum -= nums[prev++];
			}
		}
		return res == Integer.MAX_VALUE ? 0 : res;
	}
	
	public static void main(String[] args) {
		MinimumSizeSubarraySum t = new MinimumSizeSubarraySum();
		System.out.println(t.minSubArrayLen(4, new int[]{1, 4, 4}));
		System.out.println(t.minSubArrayLen(3, new int[]{1, 1}));
	}
	
	// Solution 2: Binary Search Time ~ O(NlogN), Space ~ O(N)
	public int minSubArrayLen2(int s, int[] nums) {
		int n = nums.length;
		int[] sum = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			sum[i] = sum[i - 1] + nums[i - 1]; // store sum from nums[0] to nums[i - 1]
		}
		int len = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (sum[i] + s > sum[n]) break;
//			int end = binarySearch(i + 1, n, sum[i] + s, sum);
			int t = Arrays.binarySearch(sum, i + 1, n + 1, sum[i] + s);
			int end = (t < 0) ? -t - 1 : t;
			len = Math.min(len, end - i);
		}
		return len == Integer.MAX_VALUE ? 0 : len;
	}

//	private int binarySearch(int lo, int hi, int key, int[] sum) {
//		while (lo < hi) {
//			int mid = (lo + hi) / 2;
//			if (sum[mid] < key) lo = mid + 1;
//			else if (sum[mid] > key) hi = mid;
//			else return mid;
//		}
//		return lo;
//		
//	}
}

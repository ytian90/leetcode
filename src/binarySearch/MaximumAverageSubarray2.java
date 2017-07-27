package binarySearch;
/**
 * 644. Maximum Average Subarray II
 * @author ytian
 *
 */
public class MaximumAverageSubarray2 {
	
	public static double findMaxAverage(int[] nums, int k) {
		double l = Integer.MIN_VALUE, r = Integer.MAX_VALUE;
		while (r - l > 0.000004) {
			double mid = (l + r) / 2;
			if (helper(nums, k, mid)) l = mid;
			else r = mid;
		}
		return Math.round(r * 100.0) / 100.0;
    }

	private static boolean helper(int[] nums, int k, double x) {
		int n = nums.length;
		double[] a = new double[n];
		for (int i = 0; i < n; i++) {
			a[i] = nums[i] - x;
		}
		double now = 0, last = 0;
		for (int i = 0; i < k; i++) {
			now += a[i];
		}
		if (now >= 0) return true;
		for (int i = k; i < n; i++) {
			now += a[i];
			last += a[i - k];
			if (last < 0) {
				now -= last;
				last = 0;
			}
			if (now >= 0) return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
		System.out.println(findMaxAverage(new int[]{3,3,4,3,0}, 3));
	}

}

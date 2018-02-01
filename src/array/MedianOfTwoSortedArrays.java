package array;
/**
 * 4. Median of Two Sorted Arrays
 * @author yutian
 * @since Aug 1, 2015
 */
public class MedianOfTwoSortedArrays {
	
	public static double findMedianSortedArray2(int[] nums1, int[] nums2) {
		int n1 = nums1.length, n2 = nums2.length;
		if (n1 < n2) return findMedianSortedArray2(nums2, nums1);
//		if (n2 == 0) return ((double) nums1[(n1 - 1) / 2] + (double) nums1[n1 / 2]) / 2; // optional
		int lo = 0, hi = n2 * 2;
		while (lo <= hi) {
			int mid2 = (lo + hi) / 2;
			int mid1 = n1 + n2 - mid2;
			double l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];
			double l2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];
			double r1 = (mid1 == n1 * 2) ? Integer.MAX_VALUE : nums1[(mid1) / 2];
			double r2 = (mid2 == n2 * 2) ? Integer.MAX_VALUE : nums2[(mid2) / 2];
			if (l1 > r2) lo = mid2 + 1;
			else if (l2 > r1) hi = mid2 - 1;
			else return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] t1 = new int[]{1, 2};
		int[] t2 = new int[]{3, 4};
		System.out.println(findMedianSortedArray2(t1, t2));
	}

	public static double findMedianSortedArray(int[] nums1, int[] nums2) {
		int m = nums1.length, n = nums2.length;
		int l = (m + n + 1) / 2;
		int r = (m + n + 2) / 2;
		return (helper(nums1, 0, nums2, 0, l) + helper(nums1, 0, nums2, 0, r)) / 2.0;
	}

	/*
	 * as -> A start, bs -> B start
	 * am -> A middle, bm -> B middle
	 */
	private static int helper(int[] A, int as, int[] B, int bs, int k) {
		if (as > A.length - 1) return B[bs + k - 1];
		if (bs > B.length - 1) return A[as + k - 1];
		if (k == 1) return Math.min(A[as], B[bs]);
		
		int am = Integer.MAX_VALUE, bm = Integer.MAX_VALUE;
		if (as + k / 2 - 1 < A.length) am = A[as + k / 2 - 1];
		if (bs + k / 2 - 1 < B.length) bm = B[bs + k / 2 - 1];
		
		if (am < bm) {
			return helper(A, as + k / 2, B, bs, k - k / 2);
		} else {
			return helper(A, as, B, bs + k / 2, k - k / 2);
		}
	}
	
}

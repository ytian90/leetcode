package leetcode.array;
/**
 * 4. Median of Two Sorted Arrays
 * @author yutian
 * @since Aug 1, 2015
 */
public class MedianOfTwoSortedArrays {


	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length) {
			return findMedianSortedArrays(nums2, nums1);
		}
		int x = nums1.length;
		int y = nums2.length;

		int lo = 0, hi = x;
		while (lo <= hi) {
			int partitionX = lo + (hi - lo) / 2;
			int partitionY = (x + y + 1) / 2 - partitionX;

			int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
			int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];
			int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
			int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

			if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
				if ((x + y) % 2 == 0) {
					return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
				} else {
					return (double) Math.max(maxLeftX, maxLeftY);
				}
			} else if (maxLeftX > minRightY) {
				hi = partitionX - 1;
			} else {
				lo = partitionX + 1;
			}
		}
		throw new IllegalArgumentException();
	}

	public static void main(String[] args) {
		System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
		System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
		System.out.println(findMedianSortedArrays(new int[]{23, 26, 31, 35}, new int[]{1, 5, 7, 9, 11, 16}));
		System.out.println(findMedianSortedArrays(new int[]{1, 3, 8, 9, 15}, new int[]{7, 11, 18, 19, 21, 25}));
	}
	
	public static double findMedianSortedArray2(int[] nums1, int[] nums2) {
		int n1 = nums1.length, n2 = nums2.length;
		if (n1 < n2) return findMedianSortedArray2(nums2, nums1);
//		if (n2 == 0) return ((double) nums1[(n1 - 1) / 2] + (double) nums1[n1 / 2]) / 2; // optional
		int lo = 0, hi = n2 * 2;
		while (lo <= hi) {
			int mid2 = (lo + hi) / 2; // try cut 2
			int mid1 = n1 + n2 - mid2; // calculate cut 1 accordingly
			double l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2]; // maxPerformance l1, l2, r1, r2 respectively
			double l2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];
			double r1 = (mid1 == n1 * 2) ? Integer.MAX_VALUE : nums1[(mid1) / 2];
			double r2 = (mid2 == n2 * 2) ? Integer.MAX_VALUE : nums2[(mid2) / 2];
			if (l1 > r2) lo = mid2 + 1; // A1's lower half is too big, need to move c1 left(c2 right)
			else if (l2 > r1) hi = mid2 - 1; // A2's lower half is too big, need to move c2 left
			else return (Math.max(l1, l2) + Math.min(r1, r2)) / 2; // othersize, maxPerformance right cut
		}
		return -1;
	}

	public static double findMedianSortedArray1(int[] nums1, int[] nums2) {
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

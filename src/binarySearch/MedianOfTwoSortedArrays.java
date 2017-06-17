package binarySearch;
/**
 * Median of Two Sorted Arrays
 * @author yutian
 * @since Oct 12, 2015
 * 
 * There are two sorted arrays nums1 and nums2 of size m 
 * and n respectively. Find the median of the two sorted 
 * arrays. The overall run time complexity should be O(log (m+n)).
 */
public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int N1 = nums1.length;
		int N2 = nums2.length;
		// make sure A2 is the shorter one.
		if (N1 < N2) return findMedianSortedArrays(nums2, nums1);
		
		if (N2 == 0) return ((double)nums1[(N1 - 1) / 2] + (double)nums1[N1 / 2]) / 2;
		
		int lo = 0, hi = N2 * 2;
		while (lo <= hi) {
			int mid2 = (lo + hi) / 2;
			int mid1 = N1 + N2 - mid2;
			
			double L1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];
			double L2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];
			double R1 = (mid1 == N1 * 2) ? Integer.MAX_VALUE : nums1[mid1/2];
			double R2 = (mid2 == N2 * 2) ? Integer.MAX_VALUE : nums2[mid2/2];
			
			if (L1 > R2) lo = mid2 + 1;
			else if (L2 > R1) hi = mid2 - 1;
			else return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
		}
		return -1;
	}
}

package leetcode.array;
/**
 * 88. Merge Sorted Array
 * @author yutian
 * @since Aug 10, 2015
 */
public class MergeSortedArray {
	// ascending leetcode.array
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1, j = n - 1;
		int k = m + n - 1;
		while (k >= 0) {
			if (j < 0 || i >= 0 && nums1[i] > nums2[j]) { // don't forget i >= 0
				nums1[k--] = nums1[i--];
			} else {
				nums1[k--] = nums2[j--];
			}
		}
	}
	
	// descending leetcode.array
	public static void merge2(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1, j = n - 1;
		int k = m + n - 1;
		while (k >= 0) {
			if (j < 0 || i >= 0 && nums1[i] < nums2[j]) {
				nums1[k--] = nums1[i--];
			} else {
				nums1[k--] = nums2[j--];
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a1 = new int[]{4, 5, 6, 0, 0, 0};
		int[] b1 = new int[]{1, 2, 3};
		merge(a1, 3, b1, 3);
		for (int e: a1) {
			System.out.print(e + " ");
		}
		System.out.println();
		
		int[] a2 = new int[]{6, 5, 4, 0, 0, 0};
		int[] b2 = new int[]{3, 2, 1};
		merge2(a2, 3, b2, 3);
		for (int e: a2) {
			System.out.print(e + " ");
		}
		
	}
}

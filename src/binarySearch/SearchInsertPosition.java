package binarySearch;
/**
 * 35. Search Insert Position
 * @author yutian
 * @since Sep 5, 2015
 */
public class SearchInsertPosition {
	// time ~O(logn)
	public static int searchInsert(int[] nums, int target) {
		int L = 0, R = nums.length - 1;
		while (L < R) {
			int M = L + (R - L) / 2;
			if (nums[M] < target) {
				L = M + 1;
			} else {
				R = M;
			}
		}
		return (nums[L] < target) ? L + 1 : L;
	}
	
	public static void main(String[] args) {
		int[] t1 = new int[]{1, 3, 5, 6};
		System.out.println(searchInsert(t1, 5));
		System.out.println(searchInsert(t1, 2));
		System.out.println(searchInsert(t1, 7)); // corner case for the last statement
		System.out.println(searchInsert(t1, 0));
	}
}

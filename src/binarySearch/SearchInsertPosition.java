package binarySearch;
/**
 * 35. Search Insert Position
 * @author yutian
 * @since Sep 5, 2015
 */
public class SearchInsertPosition {
	// time ~O(logn)
	public static int searchInsert(int[] nums, int target) {
		int lo = 0, hi = nums.length - 1;
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (nums[mid] < target) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		return (nums[lo] < target) ? lo + 1 : lo;
	}
	
	public static void main(String[] args) {
		int[] t1 = new int[]{1, 3, 5, 6};
		System.out.println(searchInsert(t1, 5));
		System.out.println(searchInsert(t1, 2));
		System.out.println(searchInsert(t1, 7)); // corner case for the last statement
		System.out.println(searchInsert(t1, 0));
	}
}

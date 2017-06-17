package array;
/**
 * 33. Search in Rotated Sorted Array (no duplicates)
 * @author yutian
 * @since Aug 20, 2015
 */
public class SearchInRotatedSortedArray {
	// Binary Search, Time ~O(logN) Space ~O(1)
	public static int search(int[] nums, int target) {
		int lo = 0, hi = nums.length - 1;
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (nums[mid] == target) return mid;
			if (nums[mid] < nums[hi]) {
				if (nums[mid] < target && target <= nums[hi]) {
					lo = mid + 1;
				} else {
					hi = mid;
				}
			} else { // nums[mid] > nums[hi]
				if (nums[lo] <= target && target < nums[mid]) {
					hi = mid;
				} else {
					lo = mid + 1;
				}
			}
		}
		return (nums[lo] == target) ? lo : -1;
	}
	
	public static int search2(int[] nums, int target) {
		int n = nums.length;
		int lo = 0, hi = n - 1;
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (nums[mid] > nums[hi]) lo = mid + 1;
			else hi = mid;
		}
		int rotate = lo;
		lo = 0; hi = n - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int realMid = (mid + rotate) % n;
			if (nums[realMid] == target)
				return realMid;
			if (nums[realMid] < target)
				lo = mid + 1;
			else
				hi = mid - 1;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(search(new int[]{3, 1}, 1)); // line 19
		System.out.println(search(new int[]{1, 3}, 3)); // line 15 =
		System.out.println(search(new int[]{3, 5, 1}, 3)); // line 21 =
	}
}

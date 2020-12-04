package leetcode.array;
/**
 * 81. Search in Rotated Sorted Array II
 * @author yutian
 * @since Aug 20, 2015
 */
public class SearchInRotatedSortedArray2 {
	// Time ~ O(logN) worst case ~ O(N), Space ~ O(1) 
	public static boolean search(int[] nums, int target) {
		int lo = 0, hi = nums.length - 1;
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			if (nums[mid] == target) return true;
			if (nums[mid] < nums[hi]) {
				if (nums[mid] < target && target <= nums[hi]) {
					lo = mid + 1;
				} else {
					hi = mid;
				}
			} else if (nums[mid] > nums[hi]) { // should not be nums[lo] < nums[mid]
				if (nums[lo] <= target && target < nums[mid]) {
					hi = mid;
				} else {
					lo = mid + 1;
				}
			} else {
				hi--;
			}
		}
		return (nums[lo] == target);
	}

	public static boolean seaach(int[] nums, int target) {
		int lo = 0, hi = nums.length - 1, mid = -1;
		while (lo <= hi) {
			mid = lo + (hi - lo) / 2;
			if (nums[mid] == target) return true;
			if (nums[mid] < nums[hi]) {
				if (nums[mid] < target && nums[hi] <= target) {
					lo = mid + 1;
				} else {
					hi = mid - 1;
				}
			} else if (nums[mid] > nums[hi]) {
				if (nums[lo] <= target && target < nums[mid]) {
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			} else {
				hi--;
			}
		}
		return (nums[lo] == target);
	}
	
	public static void main(String[] args) {
		System.out.println(search(new int[]{3, 1, 1}, 3)); // change line 26 to lo++
		System.out.println(search(new int[]{3, 1}, 1)); // line 19
		System.out.println(search(new int[]{1, 3}, 3)); // line 14 =
		System.out.println(search(new int[]{3, 5, 1}, 3)); // line 20 =
		System.out.println(search(new int[]{1, 1}, 0)); // delete line 26
		
	}
}

package leetcode.binarySearch;
/**
 * 162. Find Peak Element
 * @author yutian
 * @since Aug 14, 2015
 */
public class FindPeakElement {
	// Time O(logn)
	public static int findPeakElement(int[] nums) {
		int lo = 0, hi = nums.length - 1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (mid < nums.length - 1 && nums[mid] < nums[mid + 1]) {
				lo = mid + 1;
			} else if (mid > 0 && nums[mid] < nums[mid - 1]) {
				hi = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	public static int findPeakElement1(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1) return 0;
		if (nums.length == 2) return nums[0] > nums[1] ? 0 : 1;
		for (int i = 1; i < nums.length - 1; i++) {
			if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
				return i;
			}
		}
		return nums[0] > nums[nums.length - 1] ? 0 : nums.length - 1;
	}
	
	// same idea, but find the element instead of index
	public static int findPeakElement2(int[] nums) {
		int low = 0, high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (mid < nums.length - 1 && nums[mid] < nums[mid + 1]) {
				low = mid + 1;
			} else if (mid > 0 && nums[mid] < nums[mid - 1]) {
				high = mid;
			} else {
				return nums[mid];
			}
		}
		throw new IllegalArgumentException();
	}
	
	public static void main(String[] args) {
		System.out.println(findPeakElement2(new int[]{0, 1, 1, 1, 2}));
		System.out.println(findPeakElement2(new int[]{1, 3, 50, 10, 9, 7, 6}));
		System.out.println(findPeakElement2(new int[]{10, 20, 30, 40, 50}));
		System.out.println(findPeakElement2(new int[]{120, 100, 80, 20, 0}));
		System.out.println(findPeakElement2(new int[]{8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1}));
		
		
	}
}

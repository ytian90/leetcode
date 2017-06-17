package binarySearch;
/**
 * 162. Find Peak Element
 * @author yutian
 * @since Aug 14, 2015
 */
public class FindPeakElement {
	// Time O(nlogn)
	public static int findPeakElement(int[] nums) {
		int low = 0, high = nums.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (mid < nums.length - 1 && nums[mid] < nums[mid + 1]) {
				low = mid + 1;
			} else if (mid > 0 && nums[mid] < nums[mid - 1]) {
				high = mid;
			} else {
				return mid;
			}
		}
		return -1;
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

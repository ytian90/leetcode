package array;
/**
 * Min Rotated Sorted Array
 * @author yutian
 * @since Dec 16, 2015
 */
public class MinRotatedSortedArray {
	
	public int findMin(int[] nums) {
		if (nums == null || nums.length == 0) return -1;
		int len = nums.length;
		for (int i = 0; i < len - 1; i++) {
			if (nums[i] > nums[i + 1]) {
				return nums[i + 1];
			}
		}
		return nums[0];
	}

	public static void main(String[] args) {

	}

}

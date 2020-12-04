package leetcode.array;

/**
 * Move Zeros
 * @author yutian
 * @since Oct 25, 2015
 */
public class MoveZeros {

	// Time Complexity: O(n) where n is number of elements in input leetcode.array.
	// Auxiliary Space: O(1)
	public static void moveZeroes(int[] nums) {
		if (nums == null || nums.length == 0) return;
		int p = 0;
		for (int n : nums) {
			if (n != 0) nums[p++] = n;
		}
		while (p < nums.length) {
			nums[p++] = 0;
		}
	}
	

	public static void main(String[] args) {
		int[] nums = {0, 1, 0, 3, 12};
		moveZeroes(nums);
		for (int i = 0; i < nums.length; ++i) {
			System.out.println(nums[i]);
		}
	}

}

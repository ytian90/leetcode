package array;
/**
 * Next Permutation
 * @author yutian
 * @since Aug 18, 2015
 */
public class NextPermutation {
	// Time: O(N), Space: O(1)
	// from right to left, find the longest descending tail and reverse it to make 
	// ascending order, then from left to right, find the first number greater than
	// partition number(curr - 1), swap it.
	public static void nextPermutation(int[] nums) {
		int curr = nums.length - 1;
		while (curr > 0 && nums[curr - 1] >= nums[curr])
			curr--;
		reverse(nums, curr, nums.length - 1);
		// swap num[curr - 1] and the first integer element on its right side
		if (curr > 0) {
			int next = curr;
			curr--;
			while (nums[curr] >= nums[next]) next++;
			swap(nums, curr, next);
		}
	}

	private static void reverse(int[] nums, int start, int end) {
		while (start < end) {
			swap(nums, start++, end--);
		}
	}

	private static void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
	

	public static void main(String[] args) {
		int[] test1 = new int[]{1, 2, 3};
		nextPermutation(test1);
		for (int i : test1) {
			System.out.print(i + " ");
		}
	}
	
}

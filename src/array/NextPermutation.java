package array;
/**
 * 31. Next Permutation
 * @author yutian
 * @since Aug 18, 2015
 */
public class NextPermutation {
	// Time: O(N), Space: O(1)
	// from right to left, find the longest descending tail and reverse it to make 
	// ascending order, then from left to right, find the first number greater than
	// partition number(curr - 1), swap it.
	public static void nextPermutation(int[] nums) {
		int i = nums.length - 1;
		while (i > 0 && nums[i - 1] >= nums[i])
			i--;
		reverse(nums, i, nums.length - 1);
		// swap num[curr - 1] and the first integer element on its right side
		if (i > 0) {
			int j = i;
			i--;
			while (nums[i] >= nums[j]) j++;
			swap(nums, i, j);
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
		System.out.println();
		int[] test2 = new int[]{3, 2, 1};
		nextPermutation(test2);
		for (int i : test2) {
			System.out.print(i + " ");
		}
		System.out.println();
		int[] test3 = new int[]{1, 1, 5};
		nextPermutation(test3);
		for (int i : test3) {
			System.out.print(i + " ");
		}
	}
	
}

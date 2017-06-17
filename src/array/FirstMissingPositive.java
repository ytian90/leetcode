package array;
/**
 * 41. First Missing Positive
 * @author yutian
 * @since Sep 3, 2015
 */
public class FirstMissingPositive {
	
	public static void main(String[] args) {
		int[] test1 = new int[]{3, 4, -1, 1};
		System.out.println(firstMissingPositive(test1));
	}
	
	/*
	 * Ignore all the negative, > n
	 * put the other value back to its order position A[A[i] - 1]
	 * Time O(N), Space O(1)
	 */
	public static int firstMissingPositive(int[] nums) {
		int i = 0;
		while (i < nums.length) {
			if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
				int temp = nums[i];
				nums[i] = nums[temp - 1];
				nums[temp - 1] = temp;
			} else {
				i++;
			}
		}
		// find the nums[i] in wrong position
		for (i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) return i + 1;
		}
		return nums.length + 1;
	}
}

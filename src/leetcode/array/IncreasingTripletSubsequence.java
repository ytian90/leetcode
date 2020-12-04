package leetcode.array;
/**
 * 334. Increasing Triplet Subsequence
 * @author yutian
 * @since Feb 19, 2016
 */
public class IncreasingTripletSubsequence {
	
	// O(n) time complexity and O(1) space complexity
	public static boolean increasingTriplet(int[] nums) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
		for (int i : nums) {
			if (i <= small) {
				small = i;
			} else if (i <= big) {
				big = i;
			} else return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(increasingTriplet(new int[]{1, 2, 3, 4, 5}));
		System.out.println(increasingTriplet(new int[]{5, 4, 3, 2, 1}));
		System.out.println(increasingTriplet(new int[]{2, 5, 3, 4, 5}));
		System.out.println(increasingTriplet(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
		System.out.println(increasingTriplet(new int[]{1, 1, -2, 6}));
	}

}

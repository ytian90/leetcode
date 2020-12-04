package leetcode.array;
/**
 * 747. Largest Number At Least Twice of Others
 * @author ytian
 *
 */
public class LargestNumberAtLeastTwiceOfOthers {
	public static int dominantIndex(int[] nums) {
		if (nums == null || nums.length == 0)
			return -1;
		if (nums.length == 1)
			return 0;
		int res = -1, max = Integer.MIN_VALUE + 1, lessMax = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max) {
				lessMax = max;
				max = nums[i];
				res = i;
			} else if (nums[i] != max && nums[i] > lessMax) {
				lessMax = nums[i];
			}
		}
		return (lessMax * 2 > max) ? -1 : res;
	}
	
	public static void main(String[] args) {
		System.out.println(dominantIndex(new int[] {3, 6, 1, 0}));
		System.out.println(dominantIndex(new int[] {1, 2, 3, 4}));
	}
}

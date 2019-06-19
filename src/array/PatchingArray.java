package array;
/**
 * 330. Patching Array
 * @author yutian
 * @since Feb 13, 2016
 */
public class PatchingArray {
	// time O(N)
	// https://leetcode.com/discuss/82822/solution-explanation
	public int minPatches(int[] nums, int n) {
		int result = 0, i = 0;
		long total = 1;
		while (total <= n) {
			if (i < nums.length && nums[i] <= total) {
				total += nums[i++];
			} else {
				total += total; // double it
				result++;
			}
		}
		return result;
    }

	public static void main(String[] args) {
		PatchingArray t = new PatchingArray();
		System.out.println(t.minPatches(new int[]{1, 2, 4, 13, 43}, 100));
		System.out.println(t.minPatches(new int[]{1, 3}, 6));
		System.out.println(t.minPatches(new int[]{1, 5, 10}, 20));
		System.out.println(t.minPatches(new int[]{1, 2, 2}, 5));
		System.out.println(t.minPatches(new int[]{1, 2, 31, 33}, 2147483647));
		
	}

}

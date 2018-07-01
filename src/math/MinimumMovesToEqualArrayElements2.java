package math;

import java.util.Arrays;

/**
 * 462. Minimum Moves to Equal Array Elements II
 * @author ytian
 *
 */
public class MinimumMovesToEqualArrayElements2 {
	
	public static int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1, sum = 0;
        while (i < j) {
            sum += nums[j] - nums[i];
            i++; j--;
        }
        return sum;
    }

	public static void main(String[] args) {
		System.out.println(minMoves2(new int[]{1, 2, 3}));
	}

}

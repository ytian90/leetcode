package hashtable;

import java.util.Arrays;

/**
 * 645. Set Mismatch
 * @author ytian
 *
 */
public class SetMismatch {
	
	public static int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        for (int i : nums) {
        	if (nums[Math.abs(i) - 1] < 0) res[0] = Math.abs(i);
        	else nums[Math.abs(i) - 1] *= -1;
        }
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] > 0) res[1] = i + 1;
        }
        return res;
    }

	public static void main(String[] args) {
		System.out.println(Arrays.toString(findErrorNums(new int[]{1, 2, 2, 4})));
	}

}

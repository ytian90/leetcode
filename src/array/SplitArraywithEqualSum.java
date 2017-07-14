package array;

import java.util.HashSet;

/**
 * 548. Split Array with Equal Sum
 * @author ytian
 *
 */
public class SplitArraywithEqualSum {
	
	public static boolean splitArray(int[] nums) {
        if (nums.length < 7) {
        	return false;
        }
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
        	sum[i] = sum[i - 1] + nums[i];
        }
        for (int j = 3; j < nums.length - 3; j++) {
        	HashSet<Integer> set = new HashSet<>();
        	for (int i = 1; i < j - 1; i++) {
        		if (sum[i - 1] == sum[j - 1] - sum[i])
        			set.add(sum[i - 1]);
        	}
        	for (int k = j + 2; k < nums.length - 1; k++) {
        		if (sum[nums.length - 1] - sum[k] == sum[k - 1] - sum[j] && set.contains(sum[k - 1] - sum[j])) {
        			return true;
        		}
        	}
        }
        return false;
    }

	public static void main(String[] args) {
		System.out.println(splitArray(new int[]{1, 2, 1, 2, 1, 2, 1}));
	}

}

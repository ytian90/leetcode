package array;

import java.util.Arrays;

/**
 * 506. Relative Ranks
 * @author ytian
 *
 */
public class RelativeRanks {
	
	public static String[] findRelativeRanks(int[] nums) {
        Integer[] index = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
        	index[i] = i;
        }
        Arrays.sort(index, (a, b) -> (nums[b] - nums[a]));
        String[] result = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
        	if (i == 0) {
        		result[index[i]] = "Gold Medal";
        	} else if (i == 1) {
        		result[index[i]] = "Silver Medal";
        	} else if (i == 2) {
        		result[index[i]] = "Bronze Medal";
        	} else {
        		result[index[i]] = String.valueOf(i + 1);
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(findRelativeRanks(new int[]{4, 5, 3, 2, 1})));
	}

}

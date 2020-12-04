package leetcode.array;

import java.util.Arrays;

/**
 * 259. 3Sum Smaller
 * @author yutian
 * @since Dec 31, 2015
 */
public class ThreeSumSmaller {
	
	// time ~O(N^2)
	public static int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
        	int low = i + 1, high = nums.length - 1;
        	while (low < high) {
        		if (nums[i] + nums[low] + nums[high] < target) {
        			count += high - low;
        			low++;
        		} else {
        			high--;
        		}
        	}
        }
        return count;
    }

	public static void main(String[] args) {
		int[] test = new int[]{-2, 0, 1, 3, 1};
		System.out.println(threeSumSmaller(test, 2));
	}

}

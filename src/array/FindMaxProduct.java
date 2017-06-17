package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array, find two indexes, i < j && nums[i] < nums[j]
 * to make nums[i] * nums[j] is the maximum value
 * @author yutian
 * @since Jan 29, 2016
 */
public class FindMaxProduct {
	
	public static List<Integer> getMax(int[] nums) {
		int n = nums.length;
		if (n < 2) throw new IllegalArgumentException("No pairs exists\n");
		if (n == 2) return new ArrayList<Integer>(Arrays.asList(nums[0], nums[1]));
		// Initialize maximum and second maximum
		int posa = Integer.MIN_VALUE, posb = Integer.MIN_VALUE;
		// Initialize minimum and second minimum
		int nega = Integer.MIN_VALUE, negb = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			// Update maximum and second maximum if needed
			if (nums[i] > posa) {
				posb = posa;
				posa = nums[i];
			} else if (nums[i] > posb) {
				posb = nums[i];
			}
			// Update minimum and second minimum if needed
			if (nums[i] < 0 && Math.abs(nums[i]) > Math.abs(nega)) {
				negb = nega;
				nega = nums[i];
			} else if (nums[i] < 0 && Math.abs(nums[i]) > Math.abs(negb)) {
				negb = nums[i];
			}
		}
		if (nega * negb > posa * posb) {
			return new ArrayList<Integer>(Arrays.asList(nega, negb));
		} else {
			return new ArrayList<Integer>(Arrays.asList(posa, posb));
		}
		
	}

	public static void main(String[] args) {
		System.out.println(getMax(new int[]{1, 4, 3, 6, 7, 0}));
		System.out.println(getMax(new int[]{-10, 3, -3}));
	}

}

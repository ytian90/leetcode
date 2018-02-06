package array;

import java.util.Arrays;

/**
 * 3Sum Closest
 * @author yutian
 * @since Aug 16, 2015
 */
public class ThreeSumClosest {
	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int closest = nums[0] + nums[1] + nums[2];
		for (int i = 0; i < nums.length - 2; i++) {
			int a = nums[i], low = i + 1, high = nums.length - 1;
			while (low < high) {
				int b = nums[low], c = nums[high];
				int sum = a + b + c;
				if (sum == target) return sum;
				else if (Math.abs(target - sum) < Math.abs(target - closest)) {
					closest = sum;
				}
				if (target > sum) low++;
				else high--;
			}
		}
		return closest;
	}
	
	
	public static void main(String[] args) {
		int[] test = new int[]{-1, 2, 1, -4};
		System.out.println(threeSumClosest(test, 1)); // -1 + 2 + 1 = 2
	}
}

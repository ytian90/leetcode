package dynamicProgramming;

import java.util.Arrays;
import java.util.Stack;

/**
 * 321. Create Maximum Number
 * @author yutian
 * @since Feb 17, 2016
 */
public class CreateMaximumNumber {

	public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
		int n = nums1.length, m = nums2.length;
		int[] res = new int[k];
		for (int i = Math.max(0, k - m); i <= n && i <= k; i++) {
			int[] curr = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
			if (greater(curr, 0, res, 0)) res = curr;
		}
		return res;
	}

	public static int[] maxArray(int[] nums, int k) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < nums.length; i++) {
			while (!stack.isEmpty() && stack.size() + nums.length - i > k && stack.peek() < nums[i]) {
				stack.pop();
			}
			if (stack.size() < k) {
				stack.push(nums[i]);
			}
		}
		int[] res = new int[k];
		for (int i = k - 1; i >= 0; i--) {
			res[i] = stack.pop();
		}
		return res;
	}

	public static boolean greater(int[] nums1, int i, int[] nums2, int j) {
		while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
			i++;
			j++;
		}
		if (j == nums2.length || (i < nums1.length && nums1[i] > nums2[j])) {
			return true;
		} else {
			return false;
		}
	}

	public static int[] merge(int[] nums1, int[] nums2, int k) {
		int[] res = new int[k];
		for (int i = 0, j = 0, r = 0; r < k; r++) {
			res[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(maxArray(new int[]{9, 1, 2, 5, 8, 3}, 3)));
		System.out.println(Arrays.toString(maxNumber(new int[]{3, 4, 6, 5}, new int[]{9, 1, 2, 5, 8, 3}, 5)));
		System.out.println(Arrays.toString(maxNumber(new int[]{6, 7}, new int[]{6, 0, 4}, 5)));
		System.out.println(Arrays.toString(maxNumber(new int[]{1, 2}, new int[]{}, 2)));
	}

}

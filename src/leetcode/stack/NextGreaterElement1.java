package leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 496. Next Greater Element I
 * @author ytian
 *
 */
public class NextGreaterElement1 {

	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<>();
		Stack<Integer> stack= new Stack<>();
		for (int n : nums2) {
			while (!stack.isEmpty() && stack.peek() < n) {
				map.put(stack.pop(), n);
			}
			stack.push(n);
		}
		int[] res = new int[nums1.length];
		for (int i = 0; i < res.length; i++) {
			res[i] = map.getOrDefault(nums1[i], -1);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] test1_a = new int[]{4, 1, 2};
		int[] test1_b = new int[]{1, 3, 4, 2};
		for (int i : nextGreaterElement(test1_a, test1_b)) {
			System.out.print(i + " ");
		}
		System.out.println();
		int[] test2_a = new int[]{2, 4};
		int[] test2_b = new int[]{1, 2, 3, 4};
		for (int i : nextGreaterElement(test2_a, test2_b)) {
			System.out.print(i + " ");
		}
	}

}

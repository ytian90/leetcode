package binaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 315. Count of Smaller Numbers After Self
 * @author yutian
 * @since Dec 31, 2015
 */
public class CountOfSmallerNumbersAfterSelf {
	
	public static class Node {
		Node left, right;
		int val, sum, dup = 1;
		public Node (int v, int s) {
			val = v;
			sum = s;
		}
	}
	
	// Solution 1 BST Time ~O(N^2)
	public static List<Integer> countSmaller(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
        		root = insert(nums[i], root, ans, i, 0);
        }
        return Arrays.asList(ans);
    }

	/**
	 * 
	 * @param num current number
	 * @param node
	 * @param ans
	 * @param i
	 * @param preSum
	 * @return
	 */
	private static Node insert(int num, Node node, Integer[] ans, int i, int preSum) {
		if (node == null) {
			node = new Node(num, 0);
			ans[i] = preSum;
		} else if (node.val == num) {
			node.dup++;
			ans[i] = preSum + node.sum;
		} else if (node.val > num) {
			node.sum++;
			node.left = insert(num, node.left, ans, i, preSum);
		} else {
			node.right = insert(num, node.right, ans, i, preSum + node.dup + node.sum);
		}
		return node;
	}
	
	// Solution 2 Binary Search
	public static List<Integer> countSmaller2(int[] nums) {
		Integer[] ans = new Integer[nums.length];
		List<Integer> sorted = new ArrayList<Integer>();
		for (int i = nums.length - 1; i >= 0; i--) {
			int index = findIndex(sorted, nums[i]);
			ans[i] = index;
			sorted.add(index, nums[i]);
		}
		return Arrays.asList(ans);
	}

	private static int findIndex(List<Integer> sorted, int target) {
		if (sorted.size() == 0) return 0;
		int start = 0;
		int end = sorted.size() - 1;
		if (sorted.get(end) < target) return end + 1;
		if (sorted.get(start) >= target) return 0;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (sorted.get(mid) < target) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		if (sorted.get(start) >= target) return start;
		return end;
		
	}

	public static void main(String[] args) {
		int[] test = new int[]{3, 2, 2, 6, 1};
		int[] test2 = new int[]{5, 2, 6, 1};
		System.out.println(countSmaller(test));
		System.out.println(countSmaller(test2));
	}

}

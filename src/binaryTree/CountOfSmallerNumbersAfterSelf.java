package binaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 315. Count of Smaller Numbers After Self
 * @author yutian
 * @since Dec 31, 2015
 */
public class CountOfSmallerNumbersAfterSelf {
	/*
	sum: recording the total of number on it's left bottom side
	dup: counts the duplication
	 */
	public static class Node {
		Node left, right;
		int val, sum, dup;
		public Node (int val, int sum) {
			this.val = val;
			this.sum = sum;
			this.dup = 1;
		}
	}
	
	// Solution 1 BST Time ~O(N^2)
	public static List<Integer> countSmaller(int[] nums) {
        Integer[] res = new Integer[nums.length];
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
        		root = insert(nums[i], root, res, i, 0);
        }
        return Arrays.asList(res);
    }

	/**
	 * 
	 * @param num current number
	 * @param node
	 * @param res
	 * @param i
	 * @param preSum
	 * @return
	 */
	private static Node insert(int num, Node node, Integer[] res, int i, int preSum) {
		if (node == null) {
			node = new Node(num, 0);
			res[i] = preSum;
		} else if (node.val == num) {
			node.dup++;
			res[i] = preSum + node.sum;
		// The Node we are inserting is smaller than the current Node
		} else if (node.val > num) {
			/**
			 * Since we know a smaller Node will be inserted,
			 * increment the current Node's sum.
			 */
			node.sum++;
			node.left = insert(num, node.left, res, i, preSum);
		// The Node we are inserting is larger than the current Node
		} else {
			/**
			 * We know that the current Node (however many there are) and all
			 * its left-children will be smaller than the Node we are inserting,
			 * so we keep track of that during our recursion in previousSum.
			 */
			node.right = insert(num, node.right, res, i, preSum + node.dup + node.sum);
		}
		return node;
	}
	
	// Solution 2 Binary Search
	public static List<Integer> countSmaller2(int[] nums) {
		Integer[] res = new Integer[nums.length];
		List<Integer> sort = new ArrayList<Integer>();
		for (int i = nums.length - 1; i >= 0; i--) {
			int index = findIndex(sort, nums[i]);
			if (index < 0) index = -(index + 1);
			res[i] = index;
			sort.add(index, nums[i]);
		}
		return Arrays.asList(res);
	}

	private static int findIndex(List<Integer> sort, int target) {
		if (sort.size() == 0) return 0;
		int start = 0, end = sort.size() - 1;
		if (sort.get(start) >= target) return 0;
		if (sort.get(end) < target) return end + 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (sort.get(mid) < target) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		if (sort.get(start) >= target) return start;
		return end;
		
	}

	public static void main(String[] args) {
//		System.out.println(countSmaller(new int[]{3, 2, 2, 6, 1}));
//		System.out.println(countSmaller(new int[]{5, 2, 6, 1}));
//		System.out.println(countSmaller(new int[]{0, 2, 1}));
//		System.out.println(countSmaller(new int[]{-1, 0}));
//
//		System.out.println(countSmaller2(new int[]{3, 2, 2, 6, 1}));
		System.out.println(countSmaller2(new int[]{5, 2, 6, 1}));
//		System.out.println(countSmaller2(new int[]{0, 2, 1}));
//		System.out.println(countSmaller2(new int[]{-1, 0}));
	}

}

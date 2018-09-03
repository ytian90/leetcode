package binaryTree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 * @author yutian
 * @since Jul 27, 2015
 */
public class ConvertSortedArrayToBinarySearchTree {
	
	public static TreeNode sortedArrayToBST(int[] num) {
		return helper(num, 0, num.length - 1);
	}

	// Time ~O(N), Space ~O(N)
	private static TreeNode helper(int[] a, int start, int end) {
		if (start > end) return null;
		int mid = start + (end - start) / 2;
		TreeNode node = new TreeNode(a[mid]);
		node.left = helper(a, start, mid - 1);
		node.right = helper(a, mid + 1, end);
		return node;
	}

	public static TreeNode sortedArrayToBSTs(int[] nums) {
		if (nums.length == 0) return null;
		Deque<Node> stack = new LinkedList<>();
		int mid = (nums.length - 1) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		Node node = new Node(root, 0, nums.length - 1);
		stack.push(node);
		while (!stack.isEmpty()) {
			Node curr = stack.pop();
			int old = curr.start + (curr.end - curr.start) / 2;
			if (old - 1 >= curr.start) {
				mid = curr.start + (old - curr.start) / 2;
				root= new TreeNode(nums[mid]);
				stack.push(new Node(root, curr.start, old - 1));
				curr.node.left = root;
			}
			if (old + 1 <= curr.end) {
				mid = old + 1 + (curr.end - old - 1) / 2;
				root = new TreeNode(nums[mid]);
				stack.push(new Node(root, old + 1, curr.end));
				curr.node.right = root;
			}
		}
		return node.node;
	}
	
	public static void main(String[] args) {
		int[] t1 = new int[]{0};
		int[] t2 = new int[]{1, 2};
		int[] t3 = new int[]{2, 3, 4};
		TreeNode r1 = sortedArrayToBST(t1);
		TreeNode r2 = sortedArrayToBST(t2);
		TreeNode r3 = sortedArrayToBST(t3);
		printTree(r1);
		System.out.println();
		printTree(r2);
		System.out.println();
		printTree(r3);
	}
	
	private static void printTree(TreeNode n) {
		if (n == null) return;
		System.out.print(n.val + " ");
		printTree(n.left);
		printTree(n.right);
	}

	public static class Node {
		TreeNode node;
		int start;
		int end;

		public Node(TreeNode node, int start, int end) {
			this.start= start;
			this.end = end;
			this.node = node;
		}
	}
}

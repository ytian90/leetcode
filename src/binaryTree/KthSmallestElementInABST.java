package binaryTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 230. Kth Smallest Element in a BST
 * @author yutian
 * @since Aug 29, 2015
 */
public class KthSmallestElementInABST {

	// DFS in-order recursive O(N)
	public int kthSmallest0(TreeNode root, int k) {
		int[] num = new int[]{0, k}; // 0: number, 1: sort
		helper(root, num);
		return num[0];
	}

	private void helper(TreeNode node, int[] num) {
		if (node.left != null) helper(node.left, num);
		num[1]--;
		if (num[1] == 0) {
			num[0] = node.val;
			return;
		}
		if (node.right != null) helper(node.right, num);
	}

	// iterative in-order O(N)
	public int kthSmallestt(TreeNode root, int k) {
		Deque<TreeNode> stack = new LinkedList<>();
		TreeNode curr = root;
		while (curr != null || !stack.isEmpty()) {
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			k--;
			if (k == 0) return curr.val;
			curr = curr.right;
		}
		return -1;
	}

	public static void main(String[] args) {
		TreeNode n0 = new TreeNode(10);
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(15);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(7);
		TreeNode n5 = new TreeNode(13);
		TreeNode n6 = new TreeNode(18);

		n0.left = n1;
		n0.right = n2;
		n1.left = n3;
		n1.right = n4;
		n2.left = n5;
		n2.right = n6;

		KthSmallestElementInABST t = new KthSmallestElementInABST();

		System.out.println(t.kthSmallest0(n0, 2));
		System.out.println(kthLargest(n0, 2));
	}

	// bianry search :time O(N^2)==========================
	public static int kthSmallest(TreeNode root, int k) {
		int count = countNodes(root.left);
		if (k <= count) {
			return kthSmallest(root.left, k);
		} else if (k > count + 1) {
			return kthSmallest(root.right, k - count - 1);
		}
		return root.val;
	}
	
	private static int countNodes(TreeNode n) {
		if (n == null) return 0;
		return 1 + countNodes(n.left) + countNodes(n.right);
	}
	
	// kth largest element: time O(N)============================
	public static int kthLargest(TreeNode root, int k) {
		int count = countNodes(root.right);
		if (k <= count) {
			return kthLargest(root.right, k);
		} else if (k > count + 1) {
			return kthLargest(root.left, k - count - 1);
		}
		return root.val;
	}

	
	// DFS in-order iterative with stack ==========================
	public static int kthSmallest2(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode p = root;
		int count = 0;
		while (!stack.isEmpty() || p != null) {
			if (p != null) {
				stack.push(p); // just like recursion
				p = p.left;
			} else {
				TreeNode node = stack.pop();
				if (++count == k) return node.val;
				p = node.right;
			}
		}
		return Integer.MIN_VALUE;
	}
	
	// Queue time O(N)==============================================
	private static Queue<TreeNode> q = new LinkedList<>();
	
	public int kthSmallest3(TreeNode root, int k) {
		if (k == 0)         
			throw new IllegalArgumentException("k is zero!");
	    inorder(root);
	    if (q.size() < k)   
	    	throw new IllegalArgumentException("k exceeds tree size!");
	    
	    for (int i = 0; i < k - 1; i++) {
	        q.poll();
	    }
	    return q.poll().val;
	}
	
	private static void inorder(TreeNode x) {
		if (x == null)  return;
	    if (x.left != null) inorder(x.left);
	    q.add(x);
	    if (x.right != null) inorder(x.right);
	}

	//===================================================================

}

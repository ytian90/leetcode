package binaryTree;
/**
 * 270. Closest Binary Search Tree Value
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=166247&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D2%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D5%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
 * @author yutian
 * @since Jan 17, 2016
 */
public class ClosestBinarySearchTreeValue {
	// Time Complexity - O(logn)， Space Complexity - O(1)
	// Solution 1: Iterative 
	public static int closestValue(TreeNode root, double target) {
		int closestVal = root.val;
		while (root != null) {
			// update closestVal if the current value is closer to target
			closestVal = (Math.abs(target - root.val) < Math.abs(target - closestVal)) ?
					root.val : closestVal;
			if (closestVal == target) return closestVal;
			root = (root.val > target) ? root.left: root.right;
		}
		return closestVal;
	}
	
	// Solution 2: Recursive
	public static int closestValue2(TreeNode root, double target) {
		int a = root.val;
		TreeNode kid = (a > target) ? root.left : root.right;
		if (kid == null) return a;
		int b = closestValue2(kid, target);
		return Math.abs(a - target) < Math.abs(b - target) ? a : b;
	}
	
	// initial question
	public static boolean find(TreeNode root, int k) {
		if (root == null) return false;
		if (root.val == k) return true;
		return find(root.left, k) || find(root.right, k);
	}

	public static void main(String[] args) {
		/*
		 * 			10
		 * 		5		15
		 * 	   3	   12
		 */
		TreeNode n0 = new TreeNode(10);
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(15);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(12);
		n0.left = n1;
		n0.right = n2;
		n1.left = n3;
		n2.left = n4;
		
		System.out.println(closestValue(n0, 14.9));
	}

}

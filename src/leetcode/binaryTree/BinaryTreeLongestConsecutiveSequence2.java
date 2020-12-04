package leetcode.binaryTree;
/**
 * 549. Binary Tree Longest Consecutive Sequence II
 * @author ytian
 *
 */
public class BinaryTreeLongestConsecutiveSequence2 {
	
	static int max = 0;
	
	public static int longestConsecutive(TreeNode root) {
        helper(root);
        return max;
    }
	
	private static int[] helper(TreeNode node) {
		if (node == null) {
			return new int[]{0, 0};
		}
		int inc = 1, dec = 1;
		if (node.left != null) {
			int[] l = helper(node.left);
			if (node.val - node.left.val == 1) {
				dec = l[1] + 1;
			} else if (node.left.val - node.val == 1) {
				inc = l[0] + 1;
			}
		}
		if (node.right != null) {
			int[] r = helper(node.right);
			if (node.val - node.right.val == 1) {
				dec = Math.max(dec, r[1] + 1);
			} else if (node.right.val - node.val == 1) {
				inc = Math.max(inc, r[0] + 1);
			}
		}
		max = Math.max(max, dec + inc - 1);
		return new int[]{inc, dec};
	}

	public static void main(String[] args) {
		TreeNode n0 = new TreeNode(1);
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(3);
		n0.left = n1; n0.right = n2;
		
		System.out.println(longestConsecutive(n0));
		
		TreeNode n3 = new TreeNode(2);
		TreeNode n4 = new TreeNode(1);
		TreeNode n5 = new TreeNode(3);
		n3.left = n4; n3.right = n5;
		
		System.out.println(longestConsecutive(n3));
	}

}

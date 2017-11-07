package binaryTree;
/**
 * 687. Longest Univalue Path
 * @author ytian
 *
 */
public class LongestUnivaluePath {
	
	int max = 0;
    
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return max;
        count(root, Integer.MAX_VALUE);
        return max;
    }
    
    private int count(TreeNode node, int lastSeen) {
        if (node == null) return 0;
        int left = count(node.left, node.val);
        int right = count(node.right, node.val);
        max = Math.max(left + right, max);
        if (node.val == lastSeen) {
            return Math.max(left, right) + 1;
        } else {
            return 0;
        }
    }
    
    public int longestUnivaluePath2(TreeNode root) {
        if (root == null) return max;
        count(root);
        return max;
    }
    
    private int count(TreeNode node) {
        int l = node.left != null ? count(node.left) : 0;
        int r = node.right != null ? count(node.right) : 0;
        int resl = node.left != null && node.left.val == node.val ? 1 + l : 0;
        int resr = node.right != null && node.right.val == node.val ? 1 + r : 0;
        max = Math.max(max, resl + resr);
        return Math.max(resl, resr);
    }

	public static void main(String[] args) {

	}

}

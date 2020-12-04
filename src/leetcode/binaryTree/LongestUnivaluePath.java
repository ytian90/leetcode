package leetcode.binaryTree;
/**
 * 687. Longest Univalue Path
 * @author ytian
 *
 */
public class LongestUnivaluePath {

    public static int longestUnivaluePath(TreeNode root) {
        int[] max = new int[]{1};
        helper(root, max);
        return max[0] - 1;
    }

    private static int helper(TreeNode node, int[] max) {
        if (node == null) return 0;
        int left = helper(node.left, max);
        int right = helper(node.right, max);
        if (node.left == null || node.left.val != node.val) left = 0;
        if (node.right == null || node.right.val != node.val) right = 0;
        max[0] = Math.max(max[0], left + right + 1);
        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(5);
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(5);

        n0.left = n1; n0.right = n2; n1.left = n3; n1.right = n4; n2.right = n5;
        System.out.println(longestUnivaluePath(n0));
    }

    int max = 0;
    
    public int longestUnivaluePath1(TreeNode root) {
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
}

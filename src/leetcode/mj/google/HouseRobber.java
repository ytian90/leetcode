package leetcode.mj.google;

import java.util.HashMap;
import java.util.Map;

/**
 * lc337
 */
public class HouseRobber {
    // Method 1: brute force
    public static int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int val = 0;
        if (root.left != null) {
            val += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            val += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(val + root.val, rob(root.left) + rob(root.right));
    }

    // Method 2: memo
    public static int rob2(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        return helper(root, map);
    }

    private static int helper(TreeNode node, Map<TreeNode, Integer> map) {
        if (node == null) {
            return 0;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }
        int val = 0;
        if (node.left != null) {
            val += helper(node.left.left, map) + helper(node.left.right, map);
        }
        if (node.right != null) {
            val += helper(node.right.left, map) + helper(node.right.right, map);
        }
        val = Math.max(val + node.val, helper(node.left, map) + helper(node.right, map));
        map.put(node, val);
        return val;
    }

    // Method 3: DP
    public static int rob3(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }

    private static int[] helper(TreeNode node) {
        if (node == null) {
            return new int[2];
        }
        int[] left = helper(node.left);
        int[] right = helper(node.right);
        int[] res = new int[2];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = node.val + left[0] + right[0];
        return res;
    }

    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(3);
        n0.left = new TreeNode(2);
        n0.right = new TreeNode(3);
        n0.left.right = new TreeNode(3);
        n0.right.right = new TreeNode(1);

        System.out.println(rob(n0));

        TreeNode n1 = new TreeNode(3);
        n1.left = new TreeNode(4);
        n1.right = new TreeNode(5);
        n1.left.left = new TreeNode(1);
        n1.left.right = new TreeNode(3);
        n1.right.right = new TreeNode(1);

        System.out.println(rob(n1));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            this.val = x;
        }
    }
}

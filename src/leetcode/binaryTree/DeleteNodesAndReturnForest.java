package leetcode.binaryTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1110. Delete Nodes And Return Forest
 */
public class DeleteNodesAndReturnForest {
    public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Set<Integer> delSet = new HashSet<>();
        for (int i : to_delete) {
            delSet.add(i);
        }
        helper(root, delSet, res, true);
        return res;
    }

    public static void helper(TreeNode node, Set<Integer> delSet, List<TreeNode> res, boolean isParentDelNode) {
        if (node == null) {
            return;
        }
        if (delSet.contains(node.val)) {
            if (node.left == null && node.right == null) {
                return;
            }
            if (node.left != null) {
                TreeNode t = node.left;
                if (delSet.contains(node.left.val)) {
                    node.left = null;
                }
                helper(t, delSet, res, true);
            }
            if (node.right != null) {
                TreeNode t = node.right;
                if (delSet.contains(node.right.val)) {
                    node.right = null;
                }
                helper(t, delSet, res, true);
            }
        } else {
            if (isParentDelNode) {
                res.add(node);
            }
            if (node.left != null) {
                TreeNode t = node.left;
                if (delSet.contains(node.left.val)) {
                    node.left = null;
                }
                helper(t, delSet, res, false);
            }
            if (node.right != null) {
                TreeNode t = node.right;
                if (delSet.contains(node.right.val)) {
                    node.right = null;
                }
                helper(t, delSet, res, false);
            }
        }
    }

    public static List<TreeNode> delNodes2(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Set<Integer> delSet = new HashSet<>();
        for (int i : to_delete) {
            delSet.add(i);
        }
        helper2(root, delSet, res, true);
        return res;
    }

    public static TreeNode helper2(TreeNode node, Set<Integer> delSet, List<TreeNode> res, boolean is_root) {
        if (node == null) return null;
        boolean deleted = delSet.contains(node.val);
        if (is_root && !deleted) res.add(node);
        node.left = helper2(node.left, delSet, res, deleted);
        node.right = helper2(node.right, delSet, res, deleted);
        return deleted ? null : node;
    }

    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(1);
        n0.left = new TreeNode(2);
        n0.right = new TreeNode(3);
        n0.left.left = new TreeNode(4);
        n0.left.right = new TreeNode(5);
        n0.right.left = new TreeNode(6);
        n0.right.right = new TreeNode(7);
        for (TreeNode n : delNodes(n0, new int[]{3, 5})) {
            System.out.println(n.val);
        }
    }
}

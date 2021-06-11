package company.lnkin;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 366. Find Leaves of Binary Tree
 *
 * Given the root of a binary tree, collect a tree's nodes as if you were doing this:
 *
 * Collect all the leaf nodes.
 * Remove all the leaf nodes.
 * Repeat until the tree is empty.
 *
 * Example 1:
 *
 * Input: root = [1,2,3,4,5]
 * Output: [[4,5,3],[2],[1]]
 * Explanation:
 * [[3,5,4],[2],[1]] and [[3,4,5],[2],[1]] are also considered correct answers since per each level it does not matter the order on which elements are returned.
 * Example 2:
 *
 * Input: root = [1]
 * Output: [[1]]
 */
public class FindLeavesOfBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private int helper(TreeNode node, List<List<Integer>> res) {
        if (node == null) return -1;
        int height = 1 + Math.max(helper(node.left, res), helper(node.right, res));
        if (res.size() == height) {
            res.add(new ArrayList<>());
        }
        res.get(height).add(node.val);
        return height;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}



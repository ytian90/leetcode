package company.lnkin;

import leetcode.binaryTree.TreeNode;

import java.util.*;

/**
 * LC 103. Binary Tree ZigZag Level Order Traversal
 *
 *
 */
public class BinaryTreeZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder_iterative(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean flag = true;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                list.add(curr.val);
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            if (!flag) {
                Collections.reverse(list);
            }
            flag = !flag;
            res.add(list);
        }
        return res;
    }
    /**
     * Time: O(N)
     * Space: O(N)
     */

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, 0, res);
        return res;
    }

    private void helper(TreeNode node, int level, List<List<Integer>> res) {
        if (node == null) return;
        if (level == res.size()) {
            res.add(new ArrayList<>());
        }
        List<Integer> list = res.get(level);
        if (level % 2 == 0) list.add(node.val);
        else list.add(0, node.val);
        helper(node.left, level + 1, res);
        helper(node.right, level + 1, res);
    }
}

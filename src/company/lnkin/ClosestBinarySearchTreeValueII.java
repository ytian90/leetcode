package company.lnkin;

import leetcode.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * LC 272. Closest Binary Search Tree Value II
 *
 * Given the root of a binary search tree, a target value, and an integer k, return the k values in the BST that are closest to the target. You may return the answer in any order.
 *
 * You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
 *
 * Example 1:
 *
 * Input: root = [4,2,5,1,3], target = 3.714286, k = 2
 *      4
 *     / \
 *    2   5
 *   / \
 *  1   3
 * Output: [4,3]
 * Example 2:
 *
 * Input: root = [1], target = 0.000000, k = 1
 * Output: [1]
 *
 */
public class ClosestBinarySearchTreeValueII {

    // k size window + inorder traversal
    // use list/queue when data is coming in sorted order, no PriorityQueue/TreeMap in this case!
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> res = new LinkedList<>();
        helper(root, target, k, res);
        return res;
    }

    private void helper(TreeNode node, double target, int k, LinkedList<Integer> res) {
        if (node == null) return;
        helper(node.left, target, k, res);
        if (res.size() == k) {
            if (Math.abs(target - node.val) < Math.abs(target - res.peekFirst())) {
                res.removeFirst();
            } else return;
        }
        res.add(node.val);
        helper(node.right, target, k, res);
    }
}

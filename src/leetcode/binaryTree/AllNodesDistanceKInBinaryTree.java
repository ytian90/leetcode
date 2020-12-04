package leetcode.binaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 863. All Nodes Distance K in Binary Tree
 */
public class AllNodesDistanceKInBinaryTree {

    static Map<TreeNode, Integer> map = new HashMap<>();

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        find(root, target);
        dfs(root, K, map.get(root), res);
        return res;
    }

    private static void dfs(TreeNode root, int K, int length, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (map.containsKey(root)) {
            length = map.get(root);
        }
        if (length == K) {
            res.add(root.val);
        }
        dfs(root.left, K, length + 1, res);
        dfs(root.right, K, length + 1, res);
    }

    private static int find(TreeNode root, TreeNode target) {
        if (root == null) {
            return -1;
        }
        if (root == target) {
            map.put(root, 0);
            return 0;
        }
        int left = find(root.left, target);
        if (left >= 0) {
            map.put(root, left + 1);
            return left + 1;
        }
        int right = find(root.right, target);
        if (right >= 0) {
            map.put(root, right + 1);
            return right + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(3);
        n0.left = new TreeNode(5);
        n0.left.left = new TreeNode(6);
        n0.left.right = new TreeNode(2);
        n0.left.right.left = new TreeNode(7);
        n0.left.right.right = new TreeNode(4);
        n0.right = new TreeNode(1);
        n0.right.left = new TreeNode(0);
        n0.right.right = new TreeNode(8);
        System.out.println(distanceK(n0, n0.left, 2));
    }
}

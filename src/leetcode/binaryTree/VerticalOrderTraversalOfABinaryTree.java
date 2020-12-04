package leetcode.binaryTree;

import java.util.*;

/**
 * 987. Vertical Order Traversal of a Binary Tree
 */
public class VerticalOrderTraversalOfABinaryTree {
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, Map<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        helper(root, 0, 0, map);
        List<List<Integer>> res = new ArrayList<>();
        for (Map<Integer, PriorityQueue<Integer>> pqs : map.values()) {
            res.add(new ArrayList<>());
            for (PriorityQueue<Integer> pq : pqs.values()) {
                while (!pq.isEmpty()) {
                    res.get(res.size() - 1).add(pq.poll());
                }
            }
        }
        return res;
    }

    private static void helper(TreeNode root, int x, int y, Map<Integer, Map<Integer, PriorityQueue<Integer>>> map) {
        if (root == null) return;
        if (!map.containsKey(x)) {
            map.put(x, new TreeMap<>());
        }
        if (!map.get(x).containsKey(y)) {
            map.get(x).put(y, new PriorityQueue<>());
        }
        map.get(x).get(y).add(root.val);
        helper(root.left, x - 1, y + 1, map);
        helper(root.right, x + 1, y + 1, map);
    }

    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(3);
        n0.left = new TreeNode(9);
        n0.right = new TreeNode(20);
        n0.right.left = new TreeNode(15);
        n0.right.right = new TreeNode(7);

        System.out.println(verticalTraversal(n0));
    }
}

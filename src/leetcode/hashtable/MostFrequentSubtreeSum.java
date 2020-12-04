package leetcode.hashtable;

import java.util.*;

/**
 * 508. Most Frequent Subtree Sum
 */
public class MostFrequentSubtreeSum {
    public static int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        helper(root, map);
        List<Integer> list = new ArrayList<>();
        int max = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int curr = entry.getValue();
            if (curr > max) {
                list.clear();
                max = curr;
            }
            if (curr == max) {
                list.add(entry.getKey());
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    private static int helper(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) return 0;
        int left = helper(node.left, map);
        int right = helper (node.right, map);
        int sum = left + right + node.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }

    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(5);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(-3);
        n0.left = n1; n0.right = n2;
        System.out.println(Arrays.toString(findFrequentTreeSum(n0)));

        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(-5);
        n3.left = n4; n3.right = n5;
        System.out.println(Arrays.toString(findFrequentTreeSum(n3
        )));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

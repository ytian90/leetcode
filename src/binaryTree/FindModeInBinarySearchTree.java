package binaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 501. Find Mode in Binary Search Tree
 */
public class FindModeInBinarySearchTree {

    static List<Integer> res = new ArrayList<>();
    static Integer prev;
    static int maxFreq = 0, currFreq = 0;

    public static int[] findMode(TreeNode root) {
        traverse(root);
        return res.stream().mapToInt(i -> i).toArray();
    }

    private static void traverse(TreeNode node) {
        if (node == null) return;
        traverse(node.left);
        if (prev != null && node.val == prev) {
            currFreq++;
        } else {
            currFreq = 1;
        }
        if (currFreq == maxFreq) {
            res.add(node.val);
        } else if (currFreq > maxFreq) {
            maxFreq = currFreq;
            res.clear();
            res.add(node.val);
        }
        prev = node.val;
        traverse(node.right);
    }

    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(5);
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(15);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(5);
		TreeNode n5 = new TreeNode(12);

        System.out.println(Arrays.toString(findMode(n0)));
    }
}

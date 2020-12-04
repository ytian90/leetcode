package leetcode.binaryTree;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import static leetcode.util.BTreePrinter.printTreeNode;

/**
 * 654. Maximum Binary Tree
 */
public class MaximumBinaryTree {

    public static TreeNode constructMaximumBinaryTres(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return build(nums, 0, nums.length - 1);
    }

    private static TreeNode build(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int pos = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] > nums[pos]) {
                pos = i;
            }
        }
        TreeNode node = new TreeNode(nums[pos]);
        node.left = build(nums, start, pos - 1);
        node.right = build(nums, pos + 1, end);
        return node;
    }

    public static TreeNode constructMaximumBinaryTrse(int[] nums) {
        Deque<TreeNode> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            TreeNode curr = new TreeNode(nums[i]);
            while (!stack.isEmpty() && stack.peek().val < nums[i]) {
                curr.left = stack.pop();
            }
            if (!stack.isEmpty()) {
                stack.peek().right = curr;
            }
            stack.push(curr);
        }
        return stack.isEmpty() ? null : stack.removeLast();
    }


    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[pos]) {
                pos = i;
            }
        }
        TreeNode node = new TreeNode(nums[pos]);
        node.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, pos));
        node.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, pos + 1, nums.length));
        return node;
    }

    public static void main(String[] args) {
        printTreeNode(constructMaximumBinaryTres(new int[]{
                3,2,1,6,0,5
        }));
    }

}

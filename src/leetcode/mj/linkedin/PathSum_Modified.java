package leetcode.mj.linkedin;

import leetcode.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 Question;
 Path Sum的变种：给一个二叉树，每个节点的value都是one digit，比如[1,2,3,null,4] (leetcode的表示法)，
 那path就是1->2->4和1->3，那return 124+13;

 */
public class PathSum_Modified {

    public static int pathSum(TreeNode root) {
        if (root == null)
            return 0;
        List<Integer> nums = new ArrayList<>();
        findNumber(root, nums, 0);
        int sum = 0;
        for (int n : nums) sum += n;
        return sum;
    }

    public static void findNumber(TreeNode node, List<Integer> nums, int num) {
        num = num * 10 + node.val;
        if (node.left == null && node.right == null) {
            nums.add(num);
            return;
        }
        if (node.left != null) findNumber(node.left, nums, num);
        if (node.right != null) findNumber(node.right, nums, num);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n1.left = n2; n1.right = n3;
        n2.right = n4;
        System.out.println(pathSum(n1));
    }
}

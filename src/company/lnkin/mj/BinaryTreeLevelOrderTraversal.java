package company.lnkin.mj;

import leetcode.binaryTree.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                System.out.println(curr.val);
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }

    public void zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return;
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
            for (int i : list) {
                System.out.println(i);
            }
            flag = !flag;
        }
    }
}

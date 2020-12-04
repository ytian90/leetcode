package leetcode.binaryTree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 889. Construct Binary Tree from Preorder and Postorder Traversal
 */
public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {

    public static TreeNode constructFromPrePost(int[] pre, int[] post) {
        Deque<TreeNode> s = new ArrayDeque<>();
        s.offer(new TreeNode(pre[0]));
        for (int i = 1, j = 0; i < pre.length; i++) {
            TreeNode node = new TreeNode(pre[i]);
            while (s.getLast().val == post[j]) {
                s.pollLast();
                j++;
            }
            if (s.getLast().left == null) s.getLast().left = node;
            else s.getLast().right = node;
            s.offer(node);
        }
        return s.getFirst();
    }

    public static void main(String[] args) {
        System.out.println(constructFromPrePost(new int[]{1,2,4,5,3,6,7}, new int[]{4,5,2,6,7,3,1}));
    }
}

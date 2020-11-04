package binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 431. Encode N-ary Tree to Binary Tree
 */
public class EncodeNaryTreetoBinaryTree {
    // Encodes an n-ary tree to a binary tree.
    public static TreeNode encode(Node root) {
        if (root == null) {
            return null;
        }
        TreeNode treeNode = new TreeNode(root.val);
        int n = root.children.size();
        if (n > 0) {
            treeNode.left = encode(root.children.get(0));
        }
        TreeNode curr = treeNode.left;
        for (int i = 1; i < n; i++) {
            curr.right = encode(root.children.get(i));
            curr = curr.right;
        }
        return treeNode;
    }

    // Decodes your binary tree to an n-ary tree.
    public static Node decode(TreeNode root) {
        if (root == null) {
            return null;
        }
        Node node = new Node(root.val, new ArrayList<>());
        TreeNode curr = root.left;
        while (curr != null) {
            node.children.add(decode(curr));
            curr = curr.right;
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.right = new TreeNode(3);
        node.left.right.right = new TreeNode(4);
        System.out.println(SameTree.isSameTree(node, encode(decode(node))));
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
package leetcode.mj.google;

import java.util.Stack;

/**
 * 426. Convert Binary Search Tree to Sorted Doubly Linked List
 */
public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
    Node prev = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Node dummy = new Node();
        prev = dummy;
        helper(root);
        prev.right = dummy.right;
        dummy.right.left = prev;
        return dummy.right;
    }

    private void helper(Node node) {
        if (node == null) {
            return;
        }
        helper(node.left);
        prev.right = node;
        node.left = prev;
        prev = node;
        helper(node.right);
    }

    public Node treeToDoublyList2(Node root) {
        if (root == null) {
            return null;
        }
        Node curr = root, start = root;
        while (start.left != null) {
            start = start.left;
        }
        Node prev = null;
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (prev != null) {
                prev.right = curr;
                curr.left = prev;
            }
            prev = curr;
            curr = curr.right;
        }
        start.left = prev;
        prev.right = start;
        return start;
    }

    public class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val, Node _left, Node _right) {
            this.val = _val;
            this.left = _left;
            this.right = _right;
        }
    }
}

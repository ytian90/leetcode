package leetcode.binaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 590. N-ary Tree Postorder Traversal
 */
public class N_aryTreePostorderTraversal {

    public static List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public static void helper(Node root, List<Integer> res) {
        if (root == null)
            return;
        for (Node node: root.children)
            helper(node, res);
        res.add(root.val);
    }

    public static List<Integer> postorderr(Node root) {
        List<Integer> res = new ArrayList<>();
        Deque<Node> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty() && root != null) {
            Node curr = stack.pop();
            res.add(0, curr.val);
            for (Node n : curr.children) {
                stack.push(n);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Node> l1 = new ArrayList<>();
        l1.add(new Node(5, new ArrayList<>()));
        l1.add(new Node(6, new ArrayList<>()));
        Node n3 = new Node(3, l1);
        List<Node> l2 = new ArrayList<>();
        l2.add(n3);
        l2.add(new Node(2, new ArrayList<>()));
        l2.add(new Node(4, new ArrayList<>()));
        Node n1 = new Node(1, l2);
        System.out.println(postorder(n1));
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}

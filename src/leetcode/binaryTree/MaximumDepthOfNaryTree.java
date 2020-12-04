package leetcode.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 559. Maximum Depth of N-ary Tree
 */
public class MaximumDepthOfNaryTree {

    public static int maxDepth(Node root) {
        if (root == null)
            return 0;
        Queue<Node> q = new LinkedList<>();
        int res = 0;
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                if (curr.children != null && curr.children.size() > 0) {
                    q.addAll(curr.children);
                }
            }
            res++;
        }
        return res;
    }

    public static int maxDep(Node root) {
        if (root == null)
            return 0;
        int res = 0;
        for (Node n : root.children) {
            res = Math.max(res, maxDep(n));
        }
        return 1 + res;
    }

    public static void main(String[] args) {
        List<Node> l1 = new ArrayList<>();
        l1.add(new Node(5, null));
        l1.add(new Node(6, null));
        Node n3 = new Node(3, l1);
        List<Node> l2 = new ArrayList<>();
        l2.add(n3);
        l2.add(new Node(2, null));
        l2.add(new Node(4, null));
        Node n1 = new Node(1, l2);
        System.out.println(maxDepth(n1));
        System.out.println(maxDepth(null));
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

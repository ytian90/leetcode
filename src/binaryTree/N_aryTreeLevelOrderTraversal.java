package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 429. N-ary Tree Level Order Traversal
 */
public class N_aryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                list.add(curr.val);
                for (Node n : curr.children) {
                    q.add(n);
                }
                res.add(list);
            }
        }
        return res;
    }

    public List<List<Integer>> levelOrde(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, 0, res);
        return res;
    }

    private void helper(Node node, int level, List<List<Integer>> res) {
        if (node == null) return;
        if (level == res.size()) {
            res.add(new ArrayList<>());
        }
        level++;
        for (Node n : node.children) {
            helper(n, level, res);
        }
        level--;
        res.get(level).add(node.val);
    }

    public static void main(String[] args) {

    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}

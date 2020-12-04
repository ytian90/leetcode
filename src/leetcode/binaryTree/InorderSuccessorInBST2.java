package leetcode.binaryTree;

/**
 * 510. Inorder Successor in BST 2
 */
public class InorderSuccessorInBST2 {

    public Node inorderSuccessor(Node x) {
        if (x.right != null) {
            return leftMost(x.right);
        }
        Node parent = x.parent;
        while (parent != null && parent.left != x) {
            x = parent;
            parent = parent.parent;
        }
        return parent;
    }

    public Node leftMost(Node x) {
        while (x.left != null) x = x.left;
        return x;
    }


    public Node inorderSuccessor1(Node x) {
        if (x.right == null) {
            Node res = x.parent;
            while (res != null && res.val < x.val) {
                res = res.parent;
            }
            return res;
        } else {
            Node res = x.right;
            while (res.left != null) {
                res = res.left;
            }
            return res;
        }
    }


    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }
}


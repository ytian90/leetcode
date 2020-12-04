package leetcode.dfs_bfs;

import java.util.Stack;

/**
 * 430. Flatten a Multilevel Doubly Linked List
 */
public class FlattenAMultilevelDoublyLinkedList {
    public static Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        Node p = head;
        Stack<Node> prev = new Stack<>();
        while (p != null) {
            if (p.child != null) {
                if (p.next != null) {
                    prev.push(p.next);
                    p.next.prev = null;
                }
                p.next = p.child;
                p.next.prev = p;
                p.child = null;
            } else if (p.next == null && !prev.isEmpty()) {
                p.next = prev.pop();
                p.next.prev = p;
            }
            p = p.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);
        Node n11 = new Node(11);
        Node n12 = new Node(12);

        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = n6;
        n6.prev = n5; n5.prev = n4; n4.prev = n3; n3.prev = n2; n2.prev = n1;
        n3.child = n7;
        n7.next = n8; n8.next = n9; n9.next = n10;
        n10.prev = n9; n9.prev = n8; n8.prev = n7;
        n8.child = n11;
        n11.next = n12;
        n12.prev = n11;

        System.out.println(flatten(n1));
        Node p = n1;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int _val) {
            this.val = _val;
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            this.val = _val;
            this.prev = _prev;
            this.next = _next;
            this.child = _child;
        }
    }
}

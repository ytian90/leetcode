package leetcode.mj.linkedin;

/**
 Question:
 2. 双向链表，但是每一个点还可以有up，decr pointer， 已知一个链表里没有环，要求把这个链表变成标准双向链表，
 每个点的具体位置排列无所谓。楼主开始反应是递归，写好后面试官说优化一下，，空间要求是constant space，
 然后尽管面试官一直在提示tail recursion，还是没想出来（据说地里有原题，可惜当时楼主没看到。。。跪了= =！）

 time O(n);
 */
public class FlattenMetaList {
    static class MetaNode {
        MetaNode up, down, prev, next;
        int val;
        public MetaNode(int val) {
            this.val = val;
            up = null;
            down = null;
            prev = null;
            next = null;
        }
    }

    public MetaNode flatten(MetaNode input) {
        if (input == null) return null;
        MetaNode head = getHead(input);
        MetaNode mover = head;

        while (mover != null) {
            if (mover.up != null) {
                MetaNode up = mover.up;
                MetaNode upHead = getHead(up);
                MetaNode upTail = getTail(up);
                mover.prev.next = upHead;
                upHead.prev = mover.prev;
                upTail.next = mover;
                mover.prev = upTail;
                mover.up = null;
            }
            MetaNode temp = mover.next;
            if (mover.down != null) {
                MetaNode down = mover.down;
                MetaNode downHead = getHead(down);
                MetaNode downTail = getTail(down);
                mover.next = downHead;
                downHead.prev = mover;
                downTail.next = temp;
                temp.prev = downTail;
                mover.down = null;
            }
            mover = temp;
        }
        return head;
    }

    public MetaNode getHead(MetaNode node) {
        while (node.prev != null) {
            node = node.prev;
        }
        return node;
    }

    public MetaNode getTail(MetaNode node) {
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }

    public static void main(String[] args) {
        MetaNode n1 = new MetaNode(1);
        MetaNode n2 = new MetaNode(2);
        MetaNode n3 = new MetaNode(3);
        MetaNode n4 = new MetaNode(4);
        MetaNode n5 = new MetaNode(5);
        MetaNode n6 = new MetaNode(6);
        MetaNode n7 = new MetaNode(7);
        MetaNode n8 = new MetaNode(8);
        MetaNode n9 = new MetaNode(9);

        n1.next = n5; n5.prev = n1;
        n5.next = n9; n9.prev = n5;
        n2.next = n3; n3.prev = n2;
        n3.next = n4; n4.prev = n3;
        n5.up = n3;
        n6.next = n7; n7.prev = n6;
        n7.next = n8; n8.prev = n7;
        n5.down = n7;
        FlattenMetaList obj = new FlattenMetaList();
        obj.flatten(n1);
        MetaNode n = n1;
        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }
    }
}

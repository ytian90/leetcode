package mj.linkedin;

/**
 自己实现一个stack，可以O(1)实现push， pull， getMiddle，讨论了几分钟写完又跑了一下test。

 SOlution:
 a DLL, and a point to the middle one
 */
public class MidStack {
    static class Node {
        Node prev;
        Node next;
        int val;
        public Node (int val) {
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    private Node tail;
    private Node mid;
    private int len;
    public MidStack() {
        this.tail = new Node(-1);
        this.mid = tail;
        len = 0;
    }

    public void push(int val) {
        Node node = new Node(val);
        node.prev = tail;
        tail.next = node;
        tail = node;
        len++;
        if (len % 2 == 1) {
            mid = mid.next;
        }
    }

    public Integer pop() {
        if (len == 0)
            return null;
        Node node = tail;
        tail = node.prev;
        len--;
        if (len % 2 == 0) {
            mid = mid.prev;
        }
        node.prev = null;
        tail.next = null;
        return node.val;
    }

    public Integer peekMid() {
        if (len == 0) return null;
        return mid.val;
    }

    public Integer popMid() {
        if (len == 0) return null;
        Node res = mid;
        Node prev = mid.prev;
        mid.next.prev = prev;
        prev.next = mid.next;
        mid.next = null;
        mid.prev = null;
        len--;
        if (len % 2 == 0) {
            mid = prev;
        } else
            mid = prev.next;
        return res.val;
    }

    public static void main(String[] args) {
        MidStack obj = new MidStack();
        obj.push(2);
        obj.push(3);
        System.out.println(obj.peekMid());
        System.out.println(obj.popMid());
        System.out.println(obj.peekMid());
        System.out.println(obj.pop());
    }
}

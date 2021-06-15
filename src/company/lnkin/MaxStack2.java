package company.lnkin;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * LC 716. Max Stack
 *
 * Design a max stack data structure that supports the stack operations and supports finding the stack's maximum element.
 *
 * Implement the MaxStack class:
 *
 * MaxStack() Initializes the stack object.
 * void push(int x) Pushes element x onto the stack.
 * int pop() Removes the element on top of the stack and returns it.
 * int top() Gets the element on the top of the stack without removing it.
 * int peekMax() Retrieves the maximum element in the stack without removing it.
 * int popMax() Retrieves the maximum element in the stack and removes it. If there is more than one maximum element, only remove the top-most one.
 *
 * Example 1:
 *
 * Input
 * ["MaxStack", "push", "push", "push", "top", "popMax", "top", "peekMax", "pop", "top"]
 * [[], [5], [1], [5], [], [], [], [], [], []]
 * Output
 * [null, null, null, null, 5, 5, 1, 5, 1, 5]
 *
 * Explanation
 * MaxStack stk = new MaxStack();
 * stk.push(5);   // [5] the top of the stack and the maximum number is 5.
 * stk.push(1);   // [5, 1] the top of the stack is 1, but the maximum is 5.
 * stk.push(5);   // [5, 1, 5] the top of the stack is 5, which is also the maximum, because it is the top most one.
 * stk.top();     // return 5, [5, 1, 5] the stack did not change.
 * stk.popMax();  // return 5, [5, 1] the stack is changed now, and the top is different from the max.
 * stk.top();     // return 1, [5, 1] the stack did not change.
 * stk.peekMax(); // return 5, [5, 1] the stack did not change.
 * stk.pop();     // return 1, [5] the top of the stack and the max element is now 5.
 * stk.top();     // return 5, [5] the stack did not change.
 */
public class MaxStack2 {
    Node head, tail;
    TreeMap<Integer, List<Node>> map;

    public MaxStack2() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
        map = new TreeMap<>();
    }

    public void push(int x) {
        Node node = new Node(x);
        node.prev = tail.prev;
        node.next = tail;
        node.prev.next = node;
        tail.prev = node;
        if (!map.containsKey(x)) {
            map.put(x, new ArrayList<>());
        }
        map.get(x).add(node);
    }

    public int pop() {
        int val = tail.prev.val;
        removeNode(tail.prev);
        int size = map.get(val).size();
        map.get(val).remove(size - 1);
        if (size == 1) {
            map.remove(val);
        }
        return val;
    }

    public int top() {
        return tail.prev.val;
    }

    public int peekMax() {
        return map.lastKey();
    }

    public int popMax() {
        int maxVal = map.lastKey();
        int size = map.get(maxVal).size();
        Node node = map.get(maxVal).remove(size - 1);
        removeNode(node);
        if (size == 1) {
            map.remove(maxVal);
        }
        return maxVal;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    class Node {
        int val;
        Node prev;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }
}

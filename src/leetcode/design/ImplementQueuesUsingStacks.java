package leetcode.design;

import java.util.Stack;

/**
 * Implement Queue using Stacks
 * @author yutian
 * @since Aug 2, 2015
 */
public class ImplementQueuesUsingStacks {
    private Stack<Integer> curr, prev;

    /** Initialize your data structure here. */
    public ImplementQueuesUsingStacks() {
        curr = new Stack<>();
        prev = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        curr.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        shiftStack();
        return prev.pop();
    }

    /** Get the front element. */
    public int peek() {
        shiftStack();
        return prev.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return curr.isEmpty() && prev.isEmpty();
    }

    private void shiftStack() {
        if (prev.isEmpty()) {
            while (!curr.isEmpty()) {
                prev.push(curr.pop());
            }
        }
    }

    public static void main(String[] args) {
        ImplementQueuesUsingStacks obj = new ImplementQueuesUsingStacks();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.peek());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
    }
}

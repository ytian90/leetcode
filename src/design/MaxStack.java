package design;

import java.util.Stack;

/**
 * 716. Max Stack
 */
public class MaxStack {
    Stack<Integer> stack;
    Stack<Integer> maxStack;

    /**
     * initialize your data structure here.
     */
    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int x) {
        pushHelper(x);
    }

    public void pushHelper(int x) {
        int t = maxStack.isEmpty() ? Integer.MIN_VALUE : maxStack.peek();
        stack.push(x);
        maxStack.push(Math.max(x, t));
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = maxStack.peek();
        Stack<Integer> temp = new Stack<>();
        while (stack.peek() != max) {
            temp.push(stack.pop());
            maxStack.pop();
        }
        stack.pop();
        maxStack.pop();
        while (!temp.isEmpty()) {
            int x = temp.pop();
            pushHelper(x);
        }
        return max;
    }

    public static void main(String[] args) {
        MaxStack obj = new MaxStack();
        obj.push(5);
        obj.push(1);
        obj.push(5);
        System.out.println(obj.top());
        System.out.println(obj.popMax());
        System.out.println(obj.top());
        System.out.println(obj.peekMax());
        System.out.println(obj.pop());
        System.out.println(obj.top());
    }
}
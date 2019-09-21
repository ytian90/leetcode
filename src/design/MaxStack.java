package design;

import java.util.Stack;

/**
 * 716. Max Stack
 */
public class MaxStack {
    Stack<Integer> stack;
    Stack<Integer> maxStack;

    /** initialize your data structure here. */
    public MaxStack() {
        this.stack = new Stack<>();
        this.maxStack = new Stack<>();
    }

    public void push(int x) {
        int currMax = maxStack.isEmpty() ? Integer.MIN_VALUE : maxStack.peek();
        if (currMax < x) {
            currMax = x;
        }
        stack.push(x);
        maxStack.push(currMax);
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
            push(temp.pop());
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
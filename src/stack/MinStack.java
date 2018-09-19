package stack;

import java.util.Stack;

/**
 * 155. Min Stack
 * @author yutian
 * @since Jul 30, 2015
 */
public class MinStack {
	Stack<Integer> stack;
	Stack<Integer> minStack;

	/** initialize your data structure here. */
	public MinStack() {
		stack = new Stack();
		minStack = new Stack();
	}

	public void push(int x) {
		stack.push(x);
		if (minStack.isEmpty() || x <= minStack.peek()) {
			minStack.push(x);
		}
	}

	public void pop() {
		int x = stack.pop();
		if (minStack.peek() == x) {
			minStack.pop();
		}
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
        System.out.println(minStack.getMin());   //--> Returns -3.
		minStack.pop();
        System.out.println(minStack.top());      //--> Returns 0.
        System.out.println(minStack.getMin());   //--> Returns -2.
	}
}

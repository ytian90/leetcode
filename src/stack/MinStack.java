package stack;

import java.util.Stack;

/**
 * Min Stack
 * @author yutian
 * @since Jul 30, 2015
 */
public class MinStack {
	private Stack<Integer> stack = new Stack<>();
	private Stack<Integer> minStack = new Stack<>();
	
	public void push(int x) {
		stack.push(x);
		if (minStack.isEmpty() || x <= minStack.peek()) {
			minStack.push(x);
		}
	}
	
	public void pop() {
		if (stack.pop().equals(minStack.peek())) minStack.pop();
	}
	
	public int top() {
		return stack.peek();
	}
	
	public int getMin() {
		return minStack.peek();
	}
}

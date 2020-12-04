package leetcode.stack;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * 341. Flatten Nested List Iterator
 * @author yutian
 * @since Apr 8, 2016
 */
public class FlattenNestedListIterator implements Iterator<Integer> {
	Stack<NestedInteger> stack;

	public FlattenNestedListIterator(List<NestedInteger> nestedList) {
		stack = new Stack<>();
		pushListIntoStack(nestedList);
	}

	@Override
	public Integer next() {
		return stack.pop().getInteger();
	}

	private void pushListIntoStack(List<NestedInteger> list) {
		if (list == null) {
			return;
		}
		for (int i = list.size() - 1; i >= 0; i--) {
			stack.push(list.get(i));
		}
	}

	@Override
	public boolean hasNext() {
		while (!stack.isEmpty()) {
			NestedInteger curr = stack.peek();
			if (curr.isInteger()) {
				return true;
			}
			stack.pop();
			pushListIntoStack(curr.getList());
		}
		return false;
	}

	public static void main(String[] args) {

	}
	
	 // This is the interface that allows for creating nested lists.
	 // You should not implement it, or speculate about its implementation
	 public interface NestedInteger {
	     // @return true if this NestedInteger holds a single integer, rather than a nested list.
	     public boolean isInteger();
	     
	     // @return the single integer that this NestedInteger holds, if it holds a single integer
	     // Return null if this NestedInteger holds a nested list
	     public Integer getInteger();
	 
	     // @return the nested list that this NestedInteger holds, if it holds a nested list
	     // Return null if this NestedInteger holds a single integer
	     public List<NestedInteger> getList();
	 }

}

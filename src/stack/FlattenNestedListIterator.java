package stack;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * 341. Flatten Nested List Iterator
 * @author yutian
 * @since Apr 8, 2016
 */
public class FlattenNestedListIterator implements Iterator<Integer> {
	// This is a method without using iterator but easy to understand
	Stack<NestedInteger> stack = new Stack<>();
	
	public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
        	stack.push(nestedList.get(i));
        }
        
//        // another way to iterate list backward
//        ListIterator it = list.listIterator(list.size());
//        while (it.hasPrevious()) {
//            stack.push((NestedInteger)it.previous());
//        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
        	NestedInteger curr = stack.peek();
        	if (curr.isInteger()) {
        		return true;
        	}
        	stack.pop();
        	for (int i = curr.getList().size() - 1; i >= 0; i--) {
        		stack.push(curr.getList().get(i));
        	}
        }
        return false;
    }
    
    
    
//	// a little hard to understand method 
//	private Stack<ListIterator<NestedInteger>> lists; 
//	
//	public FlattenNestedListIterator(List<NestedInteger> nestedList) {
//        lists = new Stack<>();
//        lists.push(nestedList.listIterator());
//    }
//
//    @Override
//    public Integer next() {
//        hasNext();
//        return lists.peek().next().getInteger();
//    }
//
//    @Override
//    public boolean hasNext() {
//        while (!lists.isEmpty()) {
//        	if (!lists.peek().hasNext()) {
//        		lists.pop();
//        	} else {
//        		NestedInteger x = lists.peek().next();
//        		if (x.isInteger()) {
//        			return lists.peek().previous() == x; // ???
//        		}
//        		lists.push(x.getList().listIterator());
//        	}
//        }
//        return false;
//    }

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

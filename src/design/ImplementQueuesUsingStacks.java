package design;

import java.util.Stack;

/**
 * Implement Queue using Stacks
 * @author yutian
 * @since Aug 2, 2015
 */
public class ImplementQueuesUsingStacks {
	private Stack<Integer> stackNew, stackOld;
	
	public ImplementQueuesUsingStacks() {
		stackNew = new Stack<Integer>();
		stackOld = new Stack<Integer>();
	}
	// Push element x to the back of queue.
    public void push(int x) {
        stackNew.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        shiftStacks(); // Ensure stackOld has the current elements
        stackOld.pop(); // pop the oldest item
    }

    // Get the front element.
    public int peek() {
        shiftStacks();
        return stackOld.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stackNew.isEmpty() && stackOld.isEmpty();
    }
    
    // Move elements from stackNew into stackOld. This is usually done
    // so that we can do operations on stackOld.
    private void shiftStacks() {
    	if (stackOld.isEmpty()) {
    		while (!stackNew.isEmpty()) {
    			stackOld.push(stackNew.pop());
    		}
    	}
    }
}

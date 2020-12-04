package leetcode.design;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. Implement Stack using Queues
 * @author yutian
 * @since Aug 2, 2015
 */
public class ImplementStackUsingQueues {

	private Queue<Integer> q;

	/** Initialize your data structure here. */
	public ImplementStackUsingQueues() {
		q = new LinkedList<>();
	}

	/** Push element x onto leetcode.stack. */
	public void push(int x) {
		q.add(x);
		for (int i = 1; i < q.size(); i++) {
			q.add(q.remove());
		}
	}

	/** Removes the element on top of the leetcode.stack and returns that element. */
	public int pop() {
		return q.remove();
	}

	/** Get the top element. */
	public int top() {
		return q.peek();
	}

	/** Returns whether the leetcode.stack is empty. */
	public boolean empty() {
		return q.isEmpty();
	}

	public static void main(String[] args) {
		ImplementStackUsingQueues stack = new ImplementStackUsingQueues();
		stack.push(1);
		stack.push(2);
		System.out.println(stack.top());
		System.out.println(stack.pop());
		System.out.println(stack.empty());
	}

//	LinkedList<Integer> queue1 = new LinkedList<Integer>();
//	LinkedList<Integer> queue2 = new LinkedList<Integer>();
//
//	// Push element x onto leetcode.stack.
//    public void push(int x) {
//        if (empty()) {
//        	queue1.offer(x);
//        } else {
//        	if (queue1.size() > 0) {
//        		queue2.offer(x);
//        		int size = queue1.size();
//        		while (size > 0) {
//        			queue2.offer(queue1.poll());
//        			size--;
//        		}
//        	} else if (queue2.size() > 0) {
//        		queue1.offer(x);
//        		int size = queue2.size();
//        		while (size > 0) {
//        			queue1.offer(queue2.poll());
//        			size--;
//        		}
//        	}
//        }
//    }
//
//    // Removes the element on top of the leetcode.stack.
//    public void pop() {
//        if (queue1.size() > 0) {
//        	queue1.poll();
//        } else if (queue2.size() > 0) {
//        	queue2.poll();
//        }
//    }
//
//    // Get the top element.
//    public int top() {
//        if (queue1.size() > 0)
//        	return queue1.peek();
//        else if (queue2.size() > 0)
//        	return queue2.peek();
//		return 0;
//    }
//
//    // Return whether the leetcode.stack is empty.
//    public boolean empty() {
//        return queue1.isEmpty() & queue2.isEmpty();
//    }
}

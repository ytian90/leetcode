package reservoirSampling;

import java.util.Random;

import linkedList.ListNode;

/**
 * 382. Linked List Random Node
 * @author yutian
 * @since Aug 31, 2016
 */
public class LinkedListRandomNode {
	
	private ListNode head;
	private Random random;
	
	/** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
	public LinkedListRandomNode(ListNode head) {
	    this.head = head;
	    this.random = new Random();
	}
	
	/** Returns a random node's value. */
	public int getRandom() {
	    ListNode result = null;
	    ListNode current = head;
	    
	    for (int i = 1; current != null; i++) {
	    	if (random.nextInt(i) == 0) {
	    		result = current;
	    	}
	    	current = current.next;
	    }
	    
	    return result.val;
	}

	public static void main(String[] args) {

	}

}

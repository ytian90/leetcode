package linkedList;
/**
 * Delete Node in a Linked List
 * @author yutian
 * @since Aug 6, 2015
 */
public class DeleteNodeInALinkedList {
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
}

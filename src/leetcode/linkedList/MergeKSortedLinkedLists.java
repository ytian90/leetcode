package leetcode.linkedList;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 23. Merge K Sorted Linked Lists.
 * @author yutian
 * @since Jul 26, 2015
 */
public class MergeKSortedLinkedLists {

	// With Priority Queue
	// time O(Nlogk) where N is node number in list and k is number of linked lists
	// space O(N) node number in list
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;
		PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
		for (ListNode n : lists)
			if (n != null) pq.add(n);
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;
		while (!pq.isEmpty()) {
			ListNode c = pq.poll();
			p.next = c;
			p = p.next;
			if (c.next != null) {
				pq.add(c.next);
			}
		}
		return dummy.next;
	}

	private ListNode merge2Lists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				p.next = l1;
				l1 = l1.next;
			} else {
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
		}
		if (l1 != null) p.next = l1;
		if (l2 != null) p.next = l2;
		return dummy.next;
	}

	// Solution online, using ListNode[] lists
	public ListNode mergeKListsRecursion(ListNode[] lists) {
		if (lists.length == 0) return null;
		int end = lists.length - 1;
		while (end > 0) {
			int begin = 0;
			while (begin < end) {
				lists[begin] = merge2Lists(lists[begin], lists[end]);
				begin++;
				end--;
			}
		}
		return lists[0];
	}


	// Solution 1 Use Priority Queue Time O(k)
	// n means the total elements and k means the size of list
	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists.isEmpty()) return null;
		Queue<ListNode> q = new PriorityQueue<>(lists.size(), (x, y) -> x.val - y.val);
		q.addAll(lists);
		ListNode dummyHead = new ListNode(0);
		ListNode p = dummyHead;
		
		while (!q.isEmpty()) {
			ListNode node = q.poll();
			p.next = node;
			p = p.next;
			if (node.next != null) {
				q.add(node.next);
			}
		}
		return dummyHead.next;
	}
	
	
	// Solution 2 Time O(nlogk)
	// n means the total elements and k means the size of list
	public ListNode mergeKLists2(List<ListNode> lists) {
		if (lists.isEmpty()) return null;
		int end = lists.size() - 1;
		while (end > 0) {
			int begin = 0;
			while (begin < end) {
				lists.set(begin, merge2Lists(lists.get(begin), lists.get(end)));
				begin++;
				end--;
			}
		}
		return lists.get(0);
	}

}

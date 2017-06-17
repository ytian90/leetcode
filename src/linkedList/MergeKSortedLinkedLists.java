package linkedList;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Merge K Sorted Linked Lists.
 * @author yutian
 * @since Jul 26, 2015
 */
public class MergeKSortedLinkedLists {
	
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
	public ListNode mergeKLists(ListNode[] lists) {
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

	// With Priority Queue
	public ListNode mergeKLists3(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> q = new PriorityQueue<>(lists.length, (x, y) -> x.val - y.val);
        for (ListNode l: lists) {
            if (l != null) {
                q.add(l);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (!q.isEmpty()) {
            ListNode curr = q.poll();
            p.next = curr;
            p = p.next;
            if (curr.next != null) {
                q.add(curr.next);
            }
        }
        return dummy.next;
    }
}

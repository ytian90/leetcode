package divideAndConquer;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 215. Kth Largest Element in an Array
 * https://segmentfault.com/a/1190000003704825
 * @author yutian
 * @since Aug 30, 2015
 */
public class KthLargestElementInAnArray {
	// Solution 1 Time O(NlogN) Space O(N)
	// Sort the entire input array and then access the element by its index
	public static int findKthLargest(int[] nums, int k) {
		int N = nums.length;
		Arrays.sort(nums);
		return nums[N - k];
	}
	
	// Solution 2
	// Use a min oriented priority queue that will store the K-th largest values
	// time ~O(nlogn)
	public static int findKthLargest2(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(); // default is min
		for (int val : nums) {
			pq.offer(val);
			if (pq.size() > k) {
				pq.poll();
			}
		}
		return pq.peek();
	}
	
	// Solution 3: QuickSelect
	public static int findKthLargest3(int[] nums, int k) {
	    int n = nums.length;
	    int p = quickSelect(nums, 0, n - 1, n - k + 1);
	    return nums[p];
	}

	// return the index of the kth smallest number
	static int quickSelect(int[] a, int lo, int hi, int target) {
	    // use quick sort's idea
	    // put nums that are <= pivot to the left
	    // put nums that are  > pivot to the right
	    int i = lo, j = hi, pivot = a[hi];
	    while (i < j) {
	      if (a[i++] > pivot) 
	    	  swap(a, --i, --j);
	    }
	    swap(a, i, hi);

	    // sort the nums that are <= pivot from lo
	    int m = i - lo + 1;

	    // pivot is the one!
	    if (m == target)     return i;
	    // pivot is too big, so it must be on the left
	    else if (m > target) return quickSelect(a, lo, i - 1, target);
	    // pivot is too small, so it must be on the right
	    else            return quickSelect(a, i + 1, hi, target - m);
	}

	static void swap(int[] a, int i, int j) {
	    int temp = a[i];
	    a[i] = a[j];
	    a[j] = temp;
	}
	
	// what if it is a linked list
	public static int findKthLargest(ListNode n, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		ListNode p = n;
		while (p != null) {
			pq.offer(p.val);
			if (pq.size() > k) {
				pq.poll();
			}
			p = p.next;
		}
		return pq.peek();
	}
	
	public static void main(String[] args) {
		int[] t = new int[]{3, 2, 1, 5, 6, 4};
		System.out.println(findKthLargest3(t, 2));
		
//		ListNode n0 = new ListNode(3);
//		ListNode n1 = new ListNode(2);
//		ListNode n2 = new ListNode(1);
//		ListNode n3 = new ListNode(5);
//		ListNode n4 = new ListNode(6);
//		ListNode n5 = new ListNode(4);
//		n0.next = n1; n1.next = n2; n2.next = n3;
//		n3.next = n4; n4.next = n5;
//		System.out.println(findKthLargest(n0, 2));
	}

}

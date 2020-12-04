package leetcode.array;

import java.util.*;

/**
 * K largest elements in an leetcode.array
 * Write an efficient program for printing k largest elements in an leetcode.array.
 * Elements in leetcode.array can be in any order.
 * example: [1, 23, 12, 8, 30, 2, 50] k = 3 output = 23
 * @author yutian
 * @since Dec 15, 2015
 */
public class KLargestElements {

	public static void main(String[] args) {
		int[] test = new int[]{1, 23, 12, 8, 30, 2, 50};
		System.out.println(findKLargest2(test, 3));
	}
	
	// use outer loop of bubble leetcode.sort for k times
	// time O(nk)
	public static int findKLargest(int[] array, int k) {
		if (array == null) return Integer.MAX_VALUE;
		int len = array.length;
		for (int i = len - 1; i >= len - k; i--) {
			for (int j = 1; j <= i; j++) {
				if (array[j - 1] > array[j]) {
					int temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				}
			}
		}
		int[] res = new int[k];
		int idx = 0;
		for (int i = len - 1; i >= len - k; i--) {
			res[idx] = array[i];
			idx++;
		}
		return res[res.length - 1];
	}
	
	// use priority queue
	// time O(n + klogn)
	public static int findKLargest2(int[] array, int k) {
		if (array == null) return Integer.MAX_VALUE;
		int len = array.length;
		// how to use max priority queue in Java --->
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(len, new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1; // max pq
			}
		});
		for (int num : array) {
			pq.offer(num);
		}
		int[] res = new int[k];
		for (int i = 0; i < k; i++) {
			res[i] = pq.poll();
		}
		return res[k - 1];
	}

}

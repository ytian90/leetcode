package leetcode.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Merge k sorted leetcode.array
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=171564&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26sortid%3D311
 * @author yutian
 * @since Mar 6, 2016
 */
public class MergeSortedArray2 {
	
	class ArrayContainer implements Comparable<ArrayContainer> {
		int[] arr;
		int index;
		
		public ArrayContainer(int[] arr, int index) {
			this.arr = arr;
			this.index = index;
		}
		
		@Override
		public int compareTo(ArrayContainer o) {
			if (this.arr[this.index] > o.arr[o.index]) {
				return 1;
			} else if (this.arr[this.index] < o.arr[o.index]) {
				return -1;
			} else {
				return 0;
			}
		}
		
	}
	
	public int[] mergeKSortedArray(int[][] arr) {
		PriorityQueue<ArrayContainer> pq = new PriorityQueue<>();
		int total = 0;
		
		for (int i = 0; i < arr.length; i++) {
			pq.add(new ArrayContainer(arr[i], 0));
			total += arr[i].length;
		}
		
		int m = 0;
		int[] result = new int[total];
		
		// while leetcode.heap is not empty
		while (!pq.isEmpty()) {
			ArrayContainer ac = pq.poll();
			result[m++] = ac.arr[ac.index];
			if (ac.index < ac.arr.length - 1) {
				pq.add(new ArrayContainer(ac.arr, ac.index + 1));
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 3, 5, 7 };
		int[] arr2 = { 2, 4, 6, 8 };
		int[] arr3 = { 0, 9, 10, 11 };
 
		MergeSortedArray2 t = new MergeSortedArray2();
		int[] result = t.mergeKSortedArray(new int[][] { arr1, arr2, arr3 });
		System.out.println(Arrays.toString(result));
	}

}

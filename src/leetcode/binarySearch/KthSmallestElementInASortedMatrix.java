package leetcode.binarySearch;

import java.util.PriorityQueue;

/**
 * 378. Kth Smallest Element in a Sorted Matrix
 * @author yutian
 * @since Aug 15, 2016
 */
public class KthSmallestElementInASortedMatrix {

	public static int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;
		int lo = matrix[0][0], hi = matrix[n - 1][n - 1];
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			int count = getLessEqual(matrix, mid);
			if (count < k) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		return lo;
	}

	private static int getLessEqual(int[][] matrix, int val) {
		int res = 0;
		int n = matrix.length, i = n - 1, j = 0;
		while (i >= 0 && j < n) {
			if (matrix[i][j] > val) {
				i--;
			} else {
				res += i + 1;
				j++;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[][] t = new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
		System.out.println(kthSmallest(t, 8));
	}

	public static int kthSmallest2(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        for (int j = 0; j < n; j++) {
        	pq.offer(new Tuple(0, j, matrix[0][j]));
        }
        for (int i = 0; i < k - 1; i++) {
        	Tuple t = pq.poll();
        	if (t.x == n - 1) continue;
        	pq.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
        }
        return pq.poll().val;
    }
}

class Tuple implements Comparable<Tuple> {
	int x, y, val;
	public Tuple(int x, int y, int val) {
		this.x = x;
		this.y = y;
		this.val = val;
	}

	@Override
	public int compareTo(Tuple that) {
		return this.val - that.val;	
	}
}

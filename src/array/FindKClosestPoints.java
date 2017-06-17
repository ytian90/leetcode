package array;

import java.util.List;

/**
 * Find the K closest points to the origin in a 2D plane, given an
 * array containing N points.
 * http://www.zrzahid.com/k-closest-points/
 * @author yutian
 * @since Feb 1, 2016
 */
public class FindKClosestPoints {
	
	public static class Point {
		public double x;
		public double y;
		public Point(final double x, final double y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public Point[] findKClosest(Point[] p, int k) {
		int n = p.length;
		double[] dist = new double[n];
		for (int i = 0; i < n; i++) {
			dist[i] = Math.sqrt(p[i].x * p[i].x + p[i].y * p[i].y);
		}
		double kthMin = kthSmallest(dist, 0, n - 1, k);
		Point[] result = new Point[k];
		for (int i = 0, j = 0; i < n && j < k; i++) {
			double d = Math.sqrt(p[i].x * p[i].x + p[i].y * p[i].y);
			if (d <= kthMin) {
				result[j++] = p[i];
			}
		}
		return result;
	}

	private double kthSmallest(double[] A, int p, int r, int k) {
		if (p < r) {
			int q = RandomizedPartition(A, p, r);
			int n = q - p + 1;
			if (k == n) {
				return A[q];
			} else if (k < n) {
				return kthSmallest(A, p, q - 1, k);
			} else {
				return kthSmallest(A, q + 1, r, k - n);
			}
		} else {
			return Double.MIN_VALUE;
		}
	}

	private int RandomizedPartition(double[] A, int p, int r) {
		int i = (int) Math.round(p + Math.random() * (r - p));
		swap(A, i, r);
		return partition(A, p, r);
	}

	private int partition(double[] A, int start, int end) {
		double pivot = A[end];
		int i = start - 1;
		for (int j = start; j < end; j++) {
			if (A[j] <= pivot) {
				swap(A, ++i, j);
			}
		}
		swap(A, i + 1, end);
		return i + 1;
	}

	private void swap(double[] a, int i, int r) {
		double temp = a[i];
		a[i] = a[r];
		a[r] = temp;
	}

	public static void main(String[] args) {

	}

}

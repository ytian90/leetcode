package company.lnkin;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * LC 973. K Closest Points to Origin
 *
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
 *
 * The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
 *
 * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
 *
 * Example 1:
 *
 * Input: points = [[1,3],[-2,2]], k = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
 * Example 2:
 *
 * Input: points = [[3,3],[5,-1],[-2,4]], k = 2
 * Output: [[3,3],[-2,4]]
 * Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 */
public class KClosestPointsToOrigin {
    // PriorityQueue solution
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Double.compare(b.distance, a.distance));
        for (int[] p : points) {
            pq.add(new Node(p[0], p[1]));
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[][] res = new int[pq.size()][2];
        for (int i = res.length - 1; i >= 0; i--) {
            Node node = pq.poll();
            res[i] = new int[]{node.x, node.y};
        }
        return res;
    }

    class Node {
        int x, y;
        double distance;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
            this.distance = Math.sqrt(x * x + y * y);
        }
    }

    // Quick sort solution
    public int[][] kClosest2(int[][] points, int K) {
        int left = 0, right = points.length - 1;
        while (left <= right) {
            int pivot = partition(points, left, right);
            if (pivot == K) {
                break;
            }
            if (pivot > K) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return Arrays.copyOfRange(points, 0, K);
    }

    private int partition(int[][] points, int left, int right) {
        int pivot = right;
        int i = left;
        for (int j = left; j < right; j++) {
            if (distance(points[pivot], points[j]) > 0) {
                swap(points, i, j);
                i++;
            }
        }
        swap(points, i, pivot);
        return i;
    }

    private void swap(int[][] p, int i, int j) {
        int[] t = p[i];
        p[i] = p[j];
        p[j] = t;
    }

    private int distance(int[] p1, int[] p2) {
        return (p1[0] * p1[0] - p2[0] * p2[0] + p1[1] * p1[1] - p2[1] * p2[1]);
    }
}

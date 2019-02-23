package binarySearch;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 862. Shortest Subarray with Sum at Least K
 */
public class ShortestSubarrayWithSumAtLeastK {

    public static int shortestSubarray(int[] A, int K) {
        int n = A.length, res = n + 1;
        int[] B = new int[n + 1];
        for (int i = 0; i < n; i++) {
            B[i + 1] = B[i] + A[i];
        }
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            while (d.size() > 0 && B[i] - B[d.getFirst()] >= K)
                res = Math.min(res, i - d.pollFirst());
            while (d.size() > 0 && B[i] <= B[d.getLast()])
                d.pollLast();
            d.addLast(i);
        }
        return res <= n ? res : -1;
    }

    public static void main(String[] args) {
        System.out.println(shortestSubarray(new int[]{1}, 1));
        System.out.println(shortestSubarray(new int[]{1, 2}, 4));
        System.out.println(shortestSubarray(new int[]{2, -1, 2}, 3));
        System.out.println(shortestSubarray(new int[]{84, -37, 32, 40, 95}, 167));
    }
}

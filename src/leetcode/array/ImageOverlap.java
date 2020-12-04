package leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 835. Image Overlap
 */
public class ImageOverlap {

    public static int largestOverlap(int[][] A, int[][] B) {
        int N = A.length;
        List<Integer> la = new ArrayList<>();
        List<Integer> lb = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < N * N; i++) {
            if (A[i / N][i % N] == 1) {
                la.add(i / N * 100 + i % N);
            }
        }
        for (int i = 0; i < N * N; i++) {
            if (B[i / N][i % N] == 1) {
                lb.add(i / N * 100 + i % N);
            }
        }
        for (int i : la) {
            for (int j : lb) {
                count.put(i - j, count.getOrDefault(i - j, 0) + 1);
            }
        }
        int res = 0;
        for (int i : count.values()) {
            res = Math.max(res, i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(largestOverlap(new int[][]{
                {1, 1, 0},
                {0, 1, 0},
                {0, 1, 0}
        }, new int[][]{
                {0, 0, 0},
                {0, 1, 1},
                {0, 0, 1}
        }));
    }
}

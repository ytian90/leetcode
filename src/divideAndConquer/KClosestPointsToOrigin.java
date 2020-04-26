package divideAndConquer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 973. K Closest Points to Origin
 */
public class KClosestPointsToOrigin {
    public static int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return calcDistance(o1, o2);
            }
        });
        return Arrays.copyOfRange(points, 0, K);
    }

    private static int calcDistance(int[] a, int[] b) {
        return Math.sqrt(Math.pow(a[0], 2) + Math.pow(a[1], 2)) - Math.sqrt(Math.pow(b[0], 2) + Math.pow(b[1], 2)) < 0 ? -1 : 1;
    }

    public static int[][] kClosest2(int[][] points, int K) {
        int len = points.length, l = 0, r = len - 1;
        while (l <= r) {
            int mid = helper(points, l, r);
            if (mid == K) {
                break;
            }
            if (mid < K) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return Arrays.copyOfRange(points, 0, K);
    }

    private static int helper(int[][] A, int l, int r) {
        int[] pivot = A[l];
        while (l < r) {
            while (l < r && calcDistance(A[r], pivot) >= 0) {
                r--;
            }
            A[l] = A[r];
            while (l < r && calcDistance(A[l], pivot) <= 0) {
                l++;
            }
            A[r] = A[l];
        }
        A[l] = pivot;
        return l;
    }

    public static void main(String[] args) {
        for (int[] arr : kClosest2(new int[][]{
                {1, 3},
                {-2, 2}
        }, 1)) {
            System.out.println(Arrays.toString(arr));
        }

        for (int[] arr : kClosest2(new int[][]{
                {3, 3},
                {5, -1},
                {-2, 4}
        }, 2)) {
            System.out.println(Arrays.toString(arr));
        }
    }
}

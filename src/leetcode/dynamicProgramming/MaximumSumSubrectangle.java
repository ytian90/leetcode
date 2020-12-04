package leetcode.dynamicProgramming;

/**
 * Find maximum sum rectangle in 2D matrix.
 * https://www.geeksforgeeks.org/maximum-sum-rectangle-in-a-2d-matrix-dp-27/
 * https://www.youtube.com/watch?v=yCQN096CwWM&index=15&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr
 */
public class MaximumSumSubrectangle {

    // pre-requirements: Kadane's Algorithm
    // linear time to find the max subarray in leetcode.array
    public static int maxSubarray(int[] A) {
        if (A == null || A.length == 0)
            return 0;
        int currMax = A[0], globalMax = A[0];
        for (int i = 1; i < A.length; i++) {
            currMax = Math.max(A[i], currMax + A[i]);
            globalMax = Math.max(globalMax, currMax);
        }
        return globalMax;
    }

    static class Result {
        int maxSum;
        int leftBound;
        int rightBound;
        int upBound;
        int lowBound;
    }

    // maximum sum subrectangle
    // space O(rows), time (cols * cols * rows)
    public static Result maximumSumSubrectangle(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[] t = new int[rows];
        Result result = new Result();
        for (int l = 0; l < cols; l++) {
            for (int i = 0; i < rows; i++) {
                t[i] = 0;
            }
            for (int r = l; r < cols; r++) {
                for (int i = 0; i < rows; i++) {
                    t[i] += matrix[i][r];
                }
                KadaneResult curr = kadane(t);
                if (curr.maxSum > result.maxSum) {
                    result.maxSum = curr.maxSum;
                    result.leftBound = l;
                    result.rightBound = r;
                    result.upBound = curr.start;
                    result.lowBound = curr.end;
                }
            }
        }
        return result;
    }

    static class KadaneResult {
        int maxSum;
        int start;
        int end;
        public KadaneResult(int maxSum, int start, int end) {
            this.maxSum = maxSum;
            this.start = start;
            this.end = end;
        }
    }

    public static KadaneResult kadane(int[] arr) {
        int max = 0, maxStart = -1, maxEnd = -1, currStart = 0, maxSoFar = 0;
        for (int i = 0; i < arr.length; i++) {
            maxSoFar += arr[i];
            if (maxSoFar < 0) {
                maxSoFar = 0;
                currStart = i + 1;
            }
            if (max < maxSoFar) {
                max = maxSoFar;
                maxStart = currStart;
                maxEnd = i;
            }
        }
        return new KadaneResult(max, maxStart, maxEnd);
    }

    public static void main(String[] args) {
        System.out.println(maxSubarray(new int[]{-2, 3, 2, -1}));
    }
}

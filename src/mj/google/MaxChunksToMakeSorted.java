package mj.google;

/**
 * lc769 & lc768
 */
public class MaxChunksToMakeSorted {
    public static int maxChunksToSorted(int[] arr) {
        int res = 0, currMax = 0;
        for (int i = 0; i < arr.length; i++) {
            currMax = Math.max(currMax, arr[i]);
            if (currMax == i) {
                res++;
            }
        }
        return res;
    }

    public static int maxChunksToSorted2(int[] arr) {
        int n = arr.length;
        int[] maxOfLeft = new int[n];
        int[] minOfRight = new int[n];

        maxOfLeft[0] = arr[0];
        for (int i = 1; i < n; i++) {
            maxOfLeft[i] = Math.max(maxOfLeft[i - 1], arr[i]);
        }

        minOfRight[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minOfRight[i] = Math.min(minOfRight[i + 1], arr[i]);
        }
        int res = 1;
        for (int i = 0; i < n - 1; i++) {
            if (maxOfLeft[i] <= minOfRight[i + 1]) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxChunksToSorted2(new int[]{}));
    }
}

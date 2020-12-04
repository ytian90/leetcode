package leetcode.dynamicProgramming;

/**
 * 801. Minimum Swaps To Make Sequences Increasing
 */
public class MinimumSwapsToMakeSequencesIncreasing {

    public static int minSwap(int[] A, int[] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0)
            return 0;
        int n = A.length;
        int[] swap = new int[n];
        int[] noswap = new int[n];
        swap[0] = 1;
        for (int i = 1; i < n; i++) {
            noswap[i] = swap[i] = n;
            if (A[i - 1] < A[i] && B[i - 1] < B[i]) {
                noswap[i] = noswap[i - 1];
                swap[i] = swap[i - 1] + 1;
            }
            if (A[i - 1] < B[i] && B[i - 1] < A[i]) {
                noswap[i] = Math.min(noswap[i], swap[i - 1]);
                swap[i] = Math.min(swap[i], noswap[i - 1] + 1);
            }
        }
        return Math.min(swap[n - 1], noswap[n - 1]);
    }

    public static int minSwap2(int[] A, int[] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0)
            return 0;
        int n = A.length;
        int swap = 1, noswap = 0;
        for (int i = 1; i < n; i++) {
            int prev_swap = swap, prev_noswap = noswap;
            swap = n; noswap = n;
            if (A[i - 1] < A[i] && B[i - 1] < B[i]) {
                noswap = prev_noswap;
                swap = prev_swap + 1;
            }
            if (A[i - 1] < B[i] && B[i - 1] < A[i]) {
                noswap = Math.min(noswap, prev_swap);
                swap = Math.min(swap, prev_noswap + 1);
            }
        }
        return Math.min(swap, noswap);
    }

    public static void main(String[] args) {
        System.out.println(minSwap(new int[]{1, 3, 5, 4}, new int[]{1, 2, 3, 7}));
    }
}

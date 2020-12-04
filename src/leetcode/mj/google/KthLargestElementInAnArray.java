package leetcode.mj.google;

/**
 * lc215
 */
public class KthLargestElementInAnArray {
    public static int findKthLargest(int[] nums, int k) {
        return helper(nums, 0, nums.length - 1, k);
    }

    private static int helper(int[] n, int lo, int hi, int k) {
        int pivot = n[hi];
        int count = lo;
        for (int i = lo; i < hi; i++) {
            if (n[i] <= pivot) {
                swap(n, count++, i);
            }
        }
        swap(n, count, hi);
        if (count == k) {
            return n[k];
        }
        if (count < k) {
            return helper(n, count + 1, hi, k);
        } else {
            return helper(n, lo, count - 1, k);
        }
    }

    private static void swap(int[] n, int i, int j) {
        int t = n[i];
        n[i] = n[j];
        n[j] = t;
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }
}

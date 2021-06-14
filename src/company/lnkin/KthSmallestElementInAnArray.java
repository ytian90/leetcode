package company.lnkin;

/**
 * Reverse version of LC 215
 * Kth Smallest Element in an Array
 */
public class KthSmallestElementInAnArray {
    public int findKthSmallest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return sort(nums, 0, nums.length - 1, k);
    }

    private int sort(int[] nums, int lo, int hi, int k) {
        int i = lo, pivot = nums[hi];
        for (int j = lo; j < hi; j++) {
            if (nums[j] <= pivot) {
                swap(nums, j, i++);
            }
        }
        swap(nums, i, hi);
        int count = i;
        if (count == k - 1) {
            return nums[i];
        }
        if (count > k - 1) {
            return sort(nums, lo, i - 1, k);
        } else {
            return sort(nums, i + 1, hi, k);
        }
    }

    private void swap(int[] n, int i, int j) {
        int t = n[i];
        n[i] = n[j];
        n[j] = t;
    }

    public static void main(String[] args) {
        KthSmallestElementInAnArray obj = new KthSmallestElementInAnArray();
        System.out.println(obj.findKthSmallest(new int[]{3, 2, 1, 5, 6, 4}, 3));
        System.out.println(obj.findKthSmallest(new int[]{12, 3, 5, 7, 4, 19, 26}, 3));
        System.out.println(obj.findKthSmallest(new int[]{3, 2, 1, 5, 6, 4}, 6));
        System.out.println(obj.findKthSmallest(new int[]{12, 3, 5, 7, 4, 19, 26}, 6));
    }
}

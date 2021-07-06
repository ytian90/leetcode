package company.uuba;

import java.util.PriorityQueue;

/**
 * LC 215. Kth Largest Element in an Array
 *
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 *
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * Example 2:
 *
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 */
public class KthLargestElementInAnArray {
    /**
     * Time: O(N * logK)
     * Space: O(K)
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : nums) {
            pq.add(i);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    /**
     * Time: O(N) in average, O(N ^ 2) in the worst case
     * Space: O(1)
     */
    public int findKthLargest2(int[] nums, int k) {
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
        int count = hi - i + 1;
        if (count == k) {
            return nums[i];
        }
        if (count > k) {
            return sort(nums, i + 1, hi, k);
        } else {
            return sort(nums, lo, i - 1, k - count);
        }
    }

    private void swap(int[] n, int i, int j) {
        int t = n[i];
        n[i] = n[j];
        n[j] = t;
    }
}

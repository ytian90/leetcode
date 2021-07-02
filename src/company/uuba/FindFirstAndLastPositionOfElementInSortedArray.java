package company.uuba;

/**
 * LC 34. Find First and Last Position of Element in Sorted Array
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 *
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int n = nums.length;
        int index = binarySearch(nums, 0, n - 1, target);
        if (nums[index] != target) {
            return new int[]{-1, -1};
        }
        int i = index, j = index;
        while (i >= 0 && nums[i] == nums[index]) {
            i--;
        }
        while (j < n && nums[j] == nums[index]) {
            j++;
        }
        return new int[]{i + 1, j - 1};
    }

    private int binarySearch(int[] n, int lo, int hi, int target) {
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (n[mid] == target) {
                return mid;
            } else if (n[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
    /**
     * Time: O(logN)
     * Space: O(1)
     */
}

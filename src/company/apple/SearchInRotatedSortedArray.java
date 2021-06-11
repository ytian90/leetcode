package company.apple;

/**
 * https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=750686&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D4%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int lo = 0, n = nums.length, hi = n - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < nums[hi]) {
                if (nums[mid] < target && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            } else {
                if (nums[lo] <= target && target < nums[mid]) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }
        }
        return nums[lo] == target ? lo : -1;
    }

    // Time ~ O(logN) worst case ~ O(N), Space ~ O(1)
    public static boolean search2(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] < nums[hi]) {
                if (nums[mid] < target && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            } else if (nums[mid] > nums[hi]) { // should not be nums[lo] < nums[mid]
                if (nums[lo] <= target && target < nums[mid]) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            } else {
                hi--;
            }
        }
        return (nums[lo] == target);
    }

}

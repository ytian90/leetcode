package binarySearch;
/**
 * Search for a Range
 * @author yutian
 * @since Aug 29, 2015
 */
public class SearchForARange {
	
	public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums == null || nums.length == 0) return res;
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] < target) lo = mid + 1;
            else hi = mid;
        }
        if (nums[lo] != target) return res;
        else res[0] = lo;
        hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2 + 1;
            if (nums[mid] > target) hi = mid - 1;
            else lo = mid;
        }
        res[1] = hi;
        return res;
    }
	
	public static void main(String[] args) {
		for (int i : searchRange(new int[]{1}, 0)) {
			System.out.print(i + " ");
		}
		System.out.println();
		for (int i : searchRange(new int[]{}, 0)) {
			System.out.print(i + " ");
		}
		System.out.println();
		for (int i : searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)) {
			System.out.print(i + " ");
		}
		System.out.println();
		
	}
	
	// Solution 2
	public int[] searchRange2(int[] nums, int target) {
		int start = SearchForARange.firstGreaterEqual(nums, target);
		if (start == nums.length || nums[start] != target) {
			return new int[]{-1, -1};
		}
		return new int[]{start, SearchForARange.firstGreaterEqual(nums, target + 1) - 1};
	}
	
	private static int firstGreaterEqual(int[] a, int target) {
		int lo = 0, hi = a.length;
		while (lo < hi) {
			int mid = lo + ((hi - lo) >> 1);
			if (a[mid] < target) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		return lo;
	}
	
	
}

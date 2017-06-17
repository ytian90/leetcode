package array;
/**
 * 287. Find the Duplicate Number
 * @author yutian
 * @since Oct 26, 2015
 */
public class FindTheDuplicateNumber {

	public static void main(String[] args) {
		int[] t1 = new int[]{8, 8, 6, 7, 3, 4, 5, 1, 2};
		int ans1 = findDuplicate2(t1);
		System.out.println(ans1);
	}
	
	// Method 1: slow and fast pointers, linked list cycle
	// Time ~O(N)
	public static int findDuplicate(int[] nums) {
		if (nums.length > 1) {
			int slow = nums[0];
			int fast = nums[nums[0]];
			while (slow != fast) {
				slow = nums[slow];
				fast = nums[nums[fast]];
			}
			fast = 0;
			while (fast != slow) {
				fast = nums[fast];
				slow = nums[slow];
			}
			return slow;
		}
		return -1;
	}
	
	// Method 2: Binary Search - Pigeonhole principle
	// Time ~O(NlogN)
	public static int findDuplicate2(int[] nums) {
		int lo = 1, hi = nums.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int count = 0;
			for (int a : nums) {
				if (a <= mid) count++; // = test case : [1, 1]
			}
			if (count <= mid) lo = mid + 1;
			else hi = mid - 1;
		}
		return lo;
	}

}

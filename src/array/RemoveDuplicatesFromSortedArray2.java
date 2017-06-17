package array;
/**
 * 80. Remove Duplicates from Sorted Array II
 * @author yutian
 * @since Aug 20, 2015
 */
public class RemoveDuplicatesFromSortedArray2 {
	// Solution 1 time ~O(N)
	public static int removeDuplicates(int[] nums) {
		if (nums.length <= 2) return nums.length;
		int j = 1;
		for (int i = 2; i < nums.length; i++) {
			if (nums[i] != nums[j] || nums[i] != nums[j - 1]) {
				nums[++j] = nums[i];
			}
		}
		return j + 1;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 1, 1};
		int[] nums1 = {1, 1, 1, 2, 2, 3};
		int[] nums2 = {1, 2, 3, 3, 3, 4, 4, 4, 5};
		int ans = removeDuplicates(nums);
		System.out.println(ans);
	}
	
	// Solution 2
	public int removeDuplicates2(int[] nums) {
		int n = nums.length;
		if (n <= 2) return n;
		int pos = 0, numDistinct = 0;
		for (int i = 1; i < n; i++) {
			if (nums[pos] == nums[i]) {
				if (numDistinct == 0) nums[++pos] = nums[i];
				numDistinct++;
			} else {
				nums[++pos] = nums[i];
				numDistinct = 0;
			}
		}
		return pos + 1;
	}
	
	// Solution 3
	public int removeDuplicates3(int[] nums) {
		int count = 0;
		for (int i = 2; i < nums.length; i++) {
			if (nums[i] == nums[i - count - 1] && nums[i] == nums[i - count - 2]) {
				count++;
			} else if (count > 0) {
				nums[i - count] = nums[i];
			}
		}
		return nums.length - count;
	}
	
	
}

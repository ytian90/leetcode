package dynamicProgramming;
/**
 * 321. Create Maximum Number
 * @author yutian
 * @since Feb 17, 2016
 */
public class CreateMaximumNumber {
	
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length, m = nums2.length;
        int[] ans = new int[k];
        for (int i = Math.max(0, k - m); i <= k && i <= n; i++) {
        	int[] c = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
        	if (greater(c, 0, ans, 0)) ans = c;
        }
        return ans;
    }
	
	// Return true if nums1 is greater than nums2
	private boolean greater(int[] nums1, int i, int[] nums2, int j) {
		while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
			i++; j++;
		}
		return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
	}

	// Merge two arrays into array with k digits
	public int[] merge(int[] nums1, int[] nums2, int k) {
		int[] ans = new int[k];
		for (int i = 0, j = 0, r = 0; r < k; r++) {
			ans[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
		}
		return ans;
	}

	// Given one array of length n, create the maximum number of length k.
	private int[] maxArray(int[] nums, int k) {
		int n = nums.length;
		int[] ans = new int[k];
		for (int i = 0, j = 0; i < n; i++) {
			// pop the top of stack if it is smaller than nums[i]
			// until 1. stack is empty, 2. the digits left is not enough to 
			// fill the stack to size k
			while (n - i + j > k && j > 0 && ans[j - 1] < nums[i]) j--;
			if (j < k) ans[j++] = nums[i];
		}
		return ans;
	}

	public static void main(String[] args) {
		CreateMaximumNumber t = new CreateMaximumNumber();
		for (int i : t.maxArray(new int[]{6, 0, 4}, 2)) {
			System.out.println(i);
		}
		
		
//		for (int i : t.maxNumber(new int[]{6, 7}, new int[]{6, 0, 4}, 5)) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
//		for (int i : t.maxNumber(new int[]{3, 4, 6, 5}, new int[]{9, 1, 2, 5, 8, 3}, 5)) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
//		for (int i : t.maxNumber(new int[]{6, 7}, new int[]{6, 0, 4}, 5)) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
//		for (int i : t.maxNumber(new int[]{3, 9}, new int[]{8, 9}, 3)) {
//			System.out.print(i + " ");
//		}
		
	}

}

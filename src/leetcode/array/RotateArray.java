package leetcode.array;
/**
 * 189. Rotate Array
 * @author yutian
 * @since Aug 7, 2015
 */
public class RotateArray {

	public void rotato(int[] nums, int k) {
		int n = nums.length;
		int[] res = new int[n];
		k %= n;
		for (int i = 0; i < n; i++) {
			res[i] = nums[(n - k + i) % n];
		}
		System.arraycopy(res, 0, nums, 0, n);
	}
	
	public static void main(String[] args) {
		int[] test1 = new int[]{1, 2, 3, 4, 5, 6, 7};
		rotate(test1, 3);
		for (int n : test1) {
			System.out.print(n + " ");
		}
	}
	
	// Solution 1 Time ~O(N), Space O(1) Nice way
	public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n; // to check for out of bounds when k >= nums.length
        rotate(nums, 0, n - k - 1); // reverse one half of the leetcode.array
        rotate(nums, n - k, n - 1); // reverse other half of the leetcode.array
        rotate(nums, 0, n - 1); // reverse whole leetcode.array
    }
	
	public void rotate0(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        rotate(nums, 0, n - 1); // rotate the whole leetcode.array
        rotate(nums, 0, k - 1); // rotate the first half of leetcode.array
        rotate(nums, k, n - 1); // rotate the second half of leetcode.array
    }
    
    private static void rotate(int[] nums, int i, int j) {
    	while (i < j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            i++; j--;
        }
    }

	// Solution 2 make a new copy
    // Time ~O(N), Space ~O(N)
	public static void rotate2(int[] nums, int k) {
		int n = nums.length;
		if (k > n) k = k % n;
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			result[i] = nums[i];
		}
		for (int i = 0; i < n; i++) {
			if (i - k >= 0) {
				nums[i] = result[i - k];
			} else {
				nums[i] = result[n - k + i];
			}
		}
	}
	
	// Solution 3: Intermediate Array
	public static void rotate3(int[] nums, int k) {
		int n = nums.length;
		if (k > n) {
			k = k % n;
		}
		int[] result = new int[n];
		for (int i = 0; i < k; i++) {
			result[i] = nums[n - k + i];
		}
		int j = 0;
		for (int i = k; i < n; i++) {
			result[i] = nums[j++];
		}
		System.arraycopy(result, 0, nums, 0, n);
	}
	
}

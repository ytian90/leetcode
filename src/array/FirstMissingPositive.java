package array;
/**
 * 41. First Missing Positive
 * @author yutian
 * @since Sep 3, 2015
 */
public class FirstMissingPositive {

	public static int firstMissingPositive1(int[] nums) {
		int n = nums.length, max = -1;
		if (n == 0) {
			return 1;
		}
		if (n == 1 && nums[0] == 1) {
			return 2;
		}
		for (int i = 0; i < n; i++) {
			if (nums[i] == i) continue;
			if (nums[i] == n) { // handle max use case
				max = n;
			}
			if (nums[i] >= 0 && nums[i] < n && nums[nums[i]] != nums[i]) {
				swap(nums, i, nums[i]);
				i--;
			} else {
				nums[i] = -1;
			}
		}
		for (int i = 1; i < n; i++) {
			if (nums[i] == -1) {
				return i;
			}
		}
		return max == n ? max + 1 : n;
	}

	public static int firstMissingPositive(int[] nums) {
		int n = nums.length;
		if (n == 0) {
			return 1;
		}
		for (int i = 0; i < n; i++) {
			while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
				swap(nums, i, nums[i] - 1);
			}
		}
		for (int i = 0; i < n; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}
		return n + 1;
	}

	public static void swap(int[] n, int i, int j) {
		int t = n[i];
		n[i] = n[j];
		n[j] = t;
	}

	public static void main(String[] args) {
		System.out.println(firstMissingPositive(new int[]{1}));
		System.out.println(firstMissingPositive(new int[]{1, 1}));
		System.out.println(firstMissingPositive(new int[]{2, 1}));
		System.out.println(firstMissingPositive(new int[]{1, 2, 0}));
		System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1}));
		System.out.println(firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
	}
}

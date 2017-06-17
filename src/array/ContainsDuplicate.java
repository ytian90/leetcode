package array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 217. Contains Duplicate
 * @author yutian
 * @since Sep 4, 2015
 */
public class ContainsDuplicate {
	
	// brutal force Time ~O(N^2), Space ~O(1)
	public static boolean containsDuplicate1(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] == nums[j]) {
					return true;
				}
			}
		}
		return false;
	}
	
	// sort Time O(NlogN) Space O(1)
	public static boolean containsDuplicate(int[] nums) {
		Arrays.sort(nums);
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) return true;
		}
		return false;
	}
	
	// HashSet Time O(N) Space O(N)
	public static boolean containsDuplicate3(int[] nums) {
		if (nums == null || nums.length == 0) return false;
		HashSet<Integer> set = new HashSet<>();
		for (int i : nums) {
			if (!set.add(i)) return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] t = new int[]{2, 3, 5, 3, 6};
		System.out.println(containsDuplicate3(t));
	}
	
}

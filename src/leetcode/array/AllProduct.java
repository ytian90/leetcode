package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * All product
 * https://shawnlincoding.wordpress.com/page/2/
 * combination product, give leetcode.array, output all possible products
 * follow incr: dups in leetcode.array, but result has not dups
 * @author yutian
 * @since Feb 5, 2016
 */
public class AllProduct {
	
	public static List<Integer> allProduct(int[] nums) {
		List<Integer> result = new ArrayList<>();
		if (nums == null || nums.length == 0) return result;
		Arrays.sort(nums);
		dfs(nums, 1, 0, result);
		return result;
	}

	private static void dfs(int[] nums, int product, int pos, List<Integer> result) {
		for (int i = pos; i < nums.length; i++) {
			if (i != pos && nums[i - 1] == nums[i]) continue; // follow incr
			product *= nums[i];
			result.add(product);
			dfs(nums, product, i + 1, result);
			product /= nums[i];
		}
	}

	public static void main(String[] args) {
		System.out.println(allProduct(new int[]{2, 2, 2}));
		System.out.println(allProduct(new int[]{2, 3, 5}));
	}

}

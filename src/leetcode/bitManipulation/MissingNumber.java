package leetcode.bitManipulation;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 268.Missing Number
 * @author yutian
 * @since Aug 29, 2015
 */
public class MissingNumber {
	
	public static void main(String[] args) {
		MissingNumber t = new MissingNumber();
		System.out.println(t.missingNumber(new int[]{0, 1, 3}));
	}
	
	// Solution 1: Binary Search Time ~O(NlogN)
	public int missingNumber(int[] nums) {
		Arrays.sort(nums);
		int lo = 0, hi = nums.length;
		while (lo < hi) {
			int mid = lo + (hi - lo) >> 1;
			if (nums[mid] > mid) hi = mid;
			else lo = mid + 1;
		}
		return lo;
	}
	
	public int missingNumber1(int[] nums) {
        Arrays.sort(nums);
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > mid) hi = mid - 1;
            else lo = mid + 1;
        }
        return lo;
    }
	
	// Solution 2: XOR Time O(N)
	public int missingNumber2(int[] nums) {
		int res = nums.length;
		for (int i = 0; i < nums.length; i++) {
			res ^= i;
			res ^= nums[i];
		}
		return res;
	}
	
	// Solution 3: Time O(N)
	public int missingNumber3(int[] nums) {
		int len = nums.length;
		int sum = (0 + len) * (len + 1) / 2;
		for (int i = 0; i < len; i++) {
			sum -= nums[i];
		}
		return sum;
	}
	
	// Solution 4 slowest
	public int missingNumber4(int[] nums) {
		long n = nums.length;
		return (int) (n * (n + 1) / 2 - IntStream.of(nums).sum());
	}
}

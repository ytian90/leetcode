package bitManipulation;

import java.util.HashSet;
import java.util.Set;

/**
 * 421. Maximum XOR of Two Numbers in an Array
 * @author yutian
 *
 */
public class MaximumXORofTwoNumbersInAnArray {

	// http://www.cnblogs.com/grandyang/p/5991530.html
	public static int findMaximumXOR(int[] nums) {
		int max = 0, mask = 0;
		for (int i = 31; i >= 0; i--) {
			mask = mask | (1 << i);
			Set<Integer> set = new HashSet<>();
			for (int num: nums) {
				set.add(num & mask);
			}
			int t = max | (1 << i);
			for (int prefix : set) {
				if (set.contains(t ^ prefix)) {
					max = t;
					break;
				}
			}
		}
		return max;
    }

	public static void main(String[] args) {
		System.out.println(findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
		System.out.println(findMaximumXOR(new int[]{10, 23, 20, 18, 28}));
	}

}

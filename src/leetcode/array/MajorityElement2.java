package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Majority Element II
 * @author yutian
 * @since Aug 29, 2015
 */
public class MajorityElement2 {
	// Solution 1: Boyer-Moore Method
	public static List<Integer> majorityElement(int[] nums) {
		List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        // c1 - counter1, c2 - counter2, n1 - candidate1, n2 - candidate2
        int c1 = 0, c2 = 0, n1 = 0, n2 = 1;
        for (int n : nums) {
            if (n == n1) c1++;
            else if (n == n2) c2++;
            else if (c1 == 0) {
                n1 = n;
                c1 = 1;
            } else if (c2 == 0) {
                n2 = n;
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }
        c1 = c2 = 0;
        for (int n : nums) {
            if (n == n1) c1 += 2;
            else c1--;
            if (n == n2) c2 += 2;
            else c2--;
        }
        if (c1 > 0) result.add(n1);
        if (c2 > 0) result.add(n2);
        return result;
	}
	
	public static void main(String[] args) {
		System.out.println(majorityElement(new int[]{2}));
		System.out.println(majorityElement(new int[]{2, 1}));
		System.out.println(majorityElement(new int[]{2, 1, 3}));
		System.out.println(majorityElement(new int[]{2, 1, 3, 4}));
		System.out.println(majorityElement(new int[]{2, 2}));
		System.out.println(majorityElement(new int[]{2, 3, 2}));
		System.out.println(majorityElement(new int[]{2, 3, 3, 2}));
		System.out.println(majorityElement(new int[]{2, 1, 3, 3, 2}));
		System.out.println(majorityElement(new int[]{2, 1, 3, 3, 2, 1}));
	}
	
	// Solution 3
	public List<Integer> majorityElement3(int[] nums) {
		List<Integer> result = new ArrayList<>();
		if (nums == null) return result;
		int n1 = 0, n2 = 0; // 2 distinct numbers
		int c1 = 0, c2 = 0; // leetcode.sort of the 2 numbers
		for (int i = 0; i < nums.length; i++) {
			int n3 = nums[i];
			if (c1 > 0 && c2 > 0) {
				if (n3 != n1 && n3 != n2) {
					c1--;
					c2--;
				} else if (n3 == n1) {
					c1++;
				} else {
					c2++;
				}
			} else if (c1 > 0) { // c2 <= 0
				if (n3 == n1) {
					c1++;
				} else {
					n2 = n3;
					c2++;
				}
			} else if (c2 > 0) { // c1 <= 0
				if (n3 == n2) {
					c2++;
				} else {
					n1 = n3;
					c1++;
				}
			} else { 
				n1 = n3;
				c1++;
			}
		}
		c1 = c2 = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == n1) {
				c1++;
			} else if (nums[i] == n2) {
				c2++;
			}
		}
		if (c1 > nums.length / 3) {
			result.add(n1);
		}
		if (c2 > nums.length / 3) {
			result.add(n2);
		}
		return result;
	}
}

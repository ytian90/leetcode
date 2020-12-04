package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 442. Find All Duplicates in an Array
 * @author ytian
 *
 */
public class FindAllDuplicatesInAnArray {
	
	/*
	 * When find a number i, flip the number at position i - 1 to negative.
	 * If the number at position i - 1 is already negative, i is the
	 * number that occurs twice.
	 */
	public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
        	int t = Math.abs(nums[i]) - 1;
        	if (nums[t] < 0) {
        		res.add(t + 1);
        	}
        	nums[t] = -nums[t];
        }
        return res;
    }

	public static void main(String[] args) {
		int[] test = new int[]{4,3,2,7,8,2,3,1};
		System.out.println(findDuplicates(test));
	}

}

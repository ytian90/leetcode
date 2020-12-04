package leetcode.array;

import java.util.Arrays;

/**
 * 561. Array Partition I
 * @author ytian
 *
 */
public class ArrayPartition1 {
	
	public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i += 2) {
        	res += nums[i];
        }
        return res;
    }

	public static void main(String[] args) {
		System.out.println(arrayPairSum(new int[]{1,4,3,2}));
	}

}

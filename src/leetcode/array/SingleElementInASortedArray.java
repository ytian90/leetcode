package leetcode.array;
/**
 * 540. Single Element in a Sorted Array
 * @author ytian
 *
 */
public class SingleElementInASortedArray {
	
	public static int singleNonDuplicate(int[] nums) {
        int n = nums.length, lo = 0, hi = n / 2;
        while (lo < hi) {
        	int m = (lo + hi) / 2;
        	if (nums[2 * m] != nums[2 * m + 1]) hi = m;
        	else lo = m + 1;
        }
        return nums[2 * lo];
    }

	public static void main(String[] args) {
		System.out.println(singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
		System.out.println(singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
	}

}

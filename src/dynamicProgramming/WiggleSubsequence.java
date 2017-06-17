package dynamicProgramming;
/**
 * 376. Wiggle Subsequence
 * @author yutian
 * @since Aug 10, 2016
 */
public class WiggleSubsequence {
	
	public static int wiggleMaxLength(int[] nums) {
        if (nums.length < 2)
        	return nums.length;
        int maxLen = 1;
        boolean increasing = nums[1] > nums[0];
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
        	if (increasing) {
        		if (nums[i] > prev) {
        			increasing = !increasing;
        			maxLen++;
        		}
        	} else {
        		if (nums[i] < prev) {
        			increasing = !increasing;
        			maxLen++;
        		}
        	}
        	prev = nums[i];
        }
        return maxLen;
    }

	public static void main(String[] args) {
		int[] a = new int[]{1, 7, 4, 9, 2, 5};
		int[] b = new int[]{1,17,5,10,13,15,10,5,16,8};
		int[] c = new int[]{1,2,3,4,5,6,7,8,9};
		System.out.println(wiggleMaxLength(a));
		System.out.println(wiggleMaxLength(b));
		System.out.println(wiggleMaxLength(c));
	}

}

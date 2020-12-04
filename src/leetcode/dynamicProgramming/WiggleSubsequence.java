package leetcode.dynamicProgramming;
/**
 * 376. Wiggle Subsequence
 * @author yutian
 * @since Aug 10, 2016
 */
public class WiggleSubsequence {
	public static int wiggleMaxLength(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int up = 1, down = 1, n = nums.length;
		for (int i = 1; i < n; i++) {
			if (nums[i - 1] < nums[i]) {
				up = down + 1;
			} else if (nums[i - 1] > nums[i]) {
				down = up + 1;
			}
		}
		return Math.max(up, down);
	}

	public static int wiggleMaxLength1(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int n = nums.length;
		int[] up = new int[n];
		int[] down = new int[n];
		up[0] = 1;
		down[0] = 1;
		for (int i = 1; i < n; i++) {
			if (nums[i - 1] < nums[i]) {
				up[i] = down[i - 1] + 1;
				down[i] = down[i - 1];
			} else if (nums[i - 1] > nums[i]) {
				down[i] = up[i - 1] + 1;
				up[i] = up[i - 1];
			} else {
				down[i] = down[i - 1];
				up[i] = up[i - 1];
			}
		}
		return Math.max(down[n - 1], up[n - 1]);
	}
	
	public static int wiggleMaxLength2(int[] nums) {
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
		System.out.println(wiggleMaxLength(new int[]{1,7,4,9,2,5})); // 6
		System.out.println(wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8})); // 7
		System.out.println(wiggleMaxLength(new int[]{1,2,3,4,5,6,7,8,9})); // 2
		System.out.println(wiggleMaxLength(new int[]{84})); // 1
		System.out.println(wiggleMaxLength(new int[]{3,3,3,2,5})); // 2
		System.out.println(wiggleMaxLength(new int[]{126,37,130,225,239,77,235,333,30,69,294,128,163,17,224,229,128,59,
				205,265,328,259,337,93,354,316,309,67,36,88,133,359,8,335,247,209,279,94,41,62})); // 25
	}

}

package array;
/**
 * 55. Jump Game
 * @author yutian
 * @since Aug 19, 2015
 */
public class JumpGame {
	// dp
	public boolean canJump0(int[] nums) {
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i > max) return false;
			max = Math.max(nums[i] + i, max);
		}
		return true;
	}
	
	/**
	 * Greedy Algorithm, Time ~ O(N), Space ~ O(1)
	 * @param nums
	 * @return
	 */
	public static boolean canJump(int[] nums) {
		int reach = 0; // the rightmost that can jump to
		for (int i = 0; i <= reach && reach < nums.length; i++) {
			reach = Math.max(reach, i + nums[i]);
		}
		return reach >= nums.length - 1;
	}
	
	/**
	 * DP: Time ~ O(N), Space ~ O(1)
	 * Let d(i) be the number of steps that can go further at index i.
	 * @param nums
	 * @return
	 */
	public static boolean canJump2(int[] nums) {
		int d = 0;
		for (int i = 1; i < nums.length; i++) {
			d = Math.max(d, nums[i - 1]) - 1;
			if (d < 0) return false;
		}
		return d >= 0;
	}
	/**
	 * Greedy, backward
	 * @param nums
	 * @return
	 */
	public static boolean canJump3(int[] nums) {
		int n = nums.length, last = n - 1;
		for (int i = n - 2; i >= 0; i--) {
			if (i + nums[i] >= last) last = i;
		}
		return last <= 0;
	}
	
	public static void main(String[] args) {
		int[] a = new int[]{2, 3, 1, 1, 4};
		int[] b = new int[]{3, 2, 1, 0, 4};
		System.out.println(canJump(a));
		System.out.println(canJump(b));
	}
	
}

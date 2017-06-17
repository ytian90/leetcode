package array;
/**
 * Jump Game II
 * @author yutian
 * @since Aug 19, 2015
 */
public class JumpGame2 {
	// Solution 1: Greedy Algorithm
	public int jump(int[] nums) {
		int jumps = 0, next = 0, max = 0;
		for (int i = 0; i < nums.length - 1 && next < nums.length - 1; i++) {
			max = Math.max(max, i + nums[i]); // max: farthest index to reach
			if (i == next) { // ready to jump
				if (max == next) return -1; // unreachable
				next = max; // next: next position to jump
				jumps++;
			}
		}
		return jumps;
	}
	
	// Solution 2: Greedy Algorithm (more clear)
	public int jump2(int[] nums) {
		int jumps = 0;
		int prev = 0; // the farthest index that has been reached
		int max = 0; // the farthest index that can be reached
		for (int i = 0; i < nums.length; i++) {
			if (i > prev) {
				if (max == prev) return -1;
				prev = max; // greedy
				jumps++;
			}
			max = Math.max(max, i + nums[i]);
		}
		return jumps;
	}
}

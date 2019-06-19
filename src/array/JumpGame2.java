package array;
/**
 * 45. Jump Game II
 * @author yutian
 * @since Aug 19, 2015
 */
public class JumpGame2 {

	public static int jump(int[] nums) {
		if (nums.length < 2) {
			return 0;
		}
		int reach = nums[0], min = 1;
		for (int i = 1; i <= reach; i++) {
			if (reach >= nums.length - 1) {
				return min;
			}
			int localMax = 0;
			for (int j = i; j <= reach; j++) {
				localMax = Math.max(localMax, nums[j] + j);
			}
			reach = localMax;
			min++;
		}
		return (reach >= nums.length - 1) ? min : 0;
	}

	public static void main(String[] args) {
		System.out.println(jump(new int[] {2, 3, 1, 1, 4}));
		System.out.println(jump(new int[]{7,0,9,6,9,6,1,7,9,0,1,2,9,0,3}));
	}

	public static int jump1(int[] nums) {
		int jumps = 0, currEnd = 0, currMax = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			currMax = Math.max(currMax, i + nums[i]);
			if (i == currEnd) {
				jumps++;
				currEnd = currMax;
			}
		}
		return jumps;
	}


	// Solution 1: Greedy Algorithm
	public static int jump0(int[] nums) {
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
	public static int jump2(int[] nums) {
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

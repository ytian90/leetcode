package dynamicProgramming;
/**
 * 410. Split Array Largest Sum
 * @author yutian
 *
 */
public class SplitArrayLargestSum {
	
	public static int splitArray(int[] nums, int m) {
		long max = 0, sum = 0;
		for (int i : nums) {
			max = Math.max(i, max);
			sum += i;
		}
		if (m == 1) return (int) sum;
		long l = max, r = sum;
		while (l < r) {
			long mid = l + (r - l) / 2;
			if (valid(mid, nums, m)) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		return (int) l;
	}

	public static boolean valid(long target, int[] nums, int m) {
		int count = 1;
		long total = 0;
		for (int n : nums) {
			total += n;
			if (total > target) {
				total = n;
				count++;
				if (count > m) return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(splitArray(new int[]{7, 2, 5, 10, 8}, 2));

	}

}

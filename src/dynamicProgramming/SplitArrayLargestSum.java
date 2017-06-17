package dynamicProgramming;
/**
 * 410. Split Array Largest Sum
 * @author yutian
 *
 */
public class SplitArrayLargestSum {
	
	public int splitArray(int[] nums, int m) {
		long max = 0, sum = 0;
		for (int n: nums) {
			max = Math.max(max, n);
			sum += n;
		}
		if (m == 1) return (int) sum;
		long l = max, r = sum;
		while (l <= r) {
			long mid = (l + r) / 2;
			if (valid(mid, nums, m)) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return (int) l;
	}
	

	private boolean valid(long max, int[] nums, int m) {
		int count = 1;
		long total = 0;
		for (int n: nums) {
			total += n;
			if (total > max) {
				total = n;
				count++;
				if (count > m) return false;
			}
		}
		return true;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

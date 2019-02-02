package divideAndConquer;
/**
 * 327. Count of Range Sum
 * @author yutian
 * @since Feb 15, 2016
 */
public class CountOfRangeSum {

	public int countRangeSum0(int[] nums, int lower, int upper) {
		int n = nums.length;
		long[] sum = new long[n + 1];
		for (int i = 0; i < n; i++) {
			sum[i + 1] = sum[i] + nums[i];
		}
		int res = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				if (sum[j] - sum[i] >= lower && sum[j] - sum[i] <= upper) {
					res++;
				}
			}
		}
		return res;
	}
	
	// time O(n*logn)
	public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sums = new long[n + 1];
        for (int i = 0; i < n; i++) {
        	sums[i + 1] = sums[i] + nums[i];
        }
        return helper(sums, 0, n + 1, lower, upper);
    }

	private int helper(long[] sums, int start, int end, int lower, int upper) {
		if (end - start <= 1) return 0;
		int mid = start + (end - start) / 2;
		int count = helper(sums, start, mid, lower, upper)
				+ helper(sums, mid, end, lower, upper);
		int j = mid, k = mid, t = mid;
		long[] cache = new long[end - start];
		for (int i = start, r = 0; i < mid; i++, r++) {
			while (k < end && sums[k] - sums[i] < lower) k++;
			while (j < end && sums[j] - sums[i] <= upper) j++;
			while (t < end && sums[t] < sums[i]) cache[r++] = sums[t++];
			cache[r] = sums[i];
			count += j - k;
		}
		System.arraycopy(cache, 0, sums, start, t - start);
		return count;
	}

	public static void main(String[] args) {
		CountOfRangeSum t = new CountOfRangeSum();
		System.out.println(t.countRangeSum(new int[]{-2, 5, -1}, -2, 2));
		
		
	}

}

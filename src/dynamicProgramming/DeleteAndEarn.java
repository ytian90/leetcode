package dynamicProgramming;
/**
 * 740. Delete and Earn
 * @author ytian
 *
 */
public class DeleteAndEarn {
	/**
	 * If we sort all the numbers into buckets indexed by these numbers, this is essentially asking you to repetitively take an bucket while giving up the 2 buckets next to it. (the range of these numbers is [1, 10000])

		The optimal final result can be derived by keep updating 2 variables skip_i, take_i, which stands for:
		skip_i : the best result for sub-problem of first (i+1) buckets from 0 to i, while you skip the ith bucket.
		take_i : the best result for sub-problem of first (i+1) buckets from 0 to i, while you take the ith bucket.

		DP formula:
		take[i] = skip[i-1] + values[i];
		skip[i] = Math.max(skip[i-1], take[i-1]);
		take[i] can only be derived from: if you skipped the [i-1]th bucket, and you take bucket[i].
		skip[i] through, can be derived from either take[i-1] or skip[i-1], whatever the bigger;
	 * @param nums
	 * @return
	 */
	
	public static int deleteAndEarn(int[] nums) {
        int n = 10001;
        int[] values = new int[n];
        for (int num : nums) {
        	values[num] += num;
        }
        int take = 0, skip = 0;
        for (int i = 0; i < n; i++) {
			int take2 = skip + values[i];
			int skip2 = Math.max(skip, take);
			take = take2;
			skip = skip2;
        }
        return Math.max(take, skip);
    }

	public static void main(String[] args) {
		System.out.println(deleteAndEarn(new int[]{3, 4, 2}));
		System.out.println(deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
	}

}

package leetcode.dynamicProgramming;
/**
 * 307. Range Sum Query - Mutable with BIT
 * @author yutian
 * @since Feb 15, 2016
 */
public class RangeSumQueryMutable_BIT {
	// Time complexity of construction is O(nLogn) 
	// as it calls update() for all n elements
	int[] nums;
	int[] BIT;
	int n; 				// length
	
	public RangeSumQueryMutable_BIT(int[] nums) {
		this.nums = nums;
		n = nums.length;
		BIT = new int[n + 1];
		for (int i = 0; i < n; i++) {
			init(i, nums[i]);
		}
	}
	
	private void init(int i, int val) {
		i++;
		while (i <= n) {
			BIT[i] += val;
			i += (i & -i);
		}
	}

	void update(int i, int val) {
		int diff = val - nums[i];
		nums[i] = val;
		init(i, diff);
	}
	
	public int getSum(int i) {
		int sum = 0;
		i++; // index in BITree[] is 1 more than the index in arr[]
		while (i > 0) {
			sum += BIT[i];
			i -= (i & -i);
		}
		return sum;
	}
	
	public int sumRange(int i, int j) {
		return getSum(j) - getSum(i - 1);
	}

	public static void main(String[] args) {
		RangeSumQueryMutable_BIT t = 
				new RangeSumQueryMutable_BIT(new int[]{1, 3, 5});
		System.out.println(t.sumRange(0, 2));
		t.update(1, 2);
		System.out.println(t.sumRange(0, 2));
	}

}

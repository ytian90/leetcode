package dynamicProgramming;

import java.util.HashMap;

/**
 * 303. Range Sum Query - Immutable
 * @author yutian
 * @since Feb 15, 2016
 */
public class RangeSumQueryImmutable {
	
	private HashMap<Integer, Integer> map = new HashMap<>();

	public RangeSumQueryImmutable(int[] nums) {
		int sum = 0;
		map.put(-1, 0);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			map.put(i, sum);
		}
	}
	
	public int sumRange(int i, int j) {
		return map.get(j) - map.get(i - 1);
	}

	public static void main(String[] args) {
		RangeSumQueryImmutable t = new RangeSumQueryImmutable(new int[]{-2, 0, 3, -5, 2, -1});
		System.out.println(t.sumRange(0, 2));
		System.out.println(t.sumRange(2, 5));
		System.out.println(t.sumRange(0, 5));
		
	}

}

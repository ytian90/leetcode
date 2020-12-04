package leetcode.math;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Max K Products 
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=129256&fromuid=109727
 * @author yutian
 * @since Feb 4, 2016
 */
public class MaxKProducts {
	
	public static long maxKProducts(Integer[] num, int k) {
		if (num == null || num.length == 0 || k <= 0 || k > num.length)
			return 0;
		long result = Long.MIN_VALUE;
		Arrays.sort(num, new Comparator<Integer>(){
			public int compare(Integer a, Integer b) {
				if (a < 0) {
					a = a * -1;
				}
				if (b < 0) {
					b = b * -1;
				}
				return b - a;
			}
		});
		// To many corner cases..
		return result;
		
	}

	public static void main(String[] args) {
		System.out.println(maxKProducts(new Integer[]{-87,-23,-14,-8,-5,-3,-1,4,6,9,10,11,12,13}, 4));
	}

}

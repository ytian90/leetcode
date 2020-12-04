package leetcode.dynamicProgramming;

import java.util.Arrays;

/**
 * 646. Maximum Length of Pair Chain
 * @author ytian
 *
 */
public class MaximumLengthOfPairChain {
	public static int findLongestChain(int[][] pairs) {
		Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
		int res = 0, prev = Integer.MIN_VALUE;
		for (int[] pair : pairs) {
			if (pair[0] > prev) {
				res++;
				prev = pair[1];
			} else {
				prev = Math.min(prev, pair[1]);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[][] t = new int[][]{{1, 2}, {2, 3}, {3, 4}};
		System.out.println(findLongestChain(t));
	}

	public static int findLongestChains(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int sum = 0, n = pairs.length, i = -1;
        while (++i < n) {
        	sum++;
        	int currEnd = pairs[i][1];
        	while (i + 1 < n && pairs[i + 1][0] <= currEnd) i++;
        }
        return sum;
    }

}

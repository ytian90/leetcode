package leetcode.dynamicProgramming;

import java.util.HashMap;

/**
 * 446. Arithmetic Slices 2 - Subsequence
 * @author yutian
 *
 */
public class ArithmeticSlices2Subsequence {
	
	public static int numberOfArithmeticSlices(int[] A) {
        int res = 0;
        HashMap<Integer, Integer>[] maps = new HashMap[A.length];
        for (int i = 0; i < A.length; i++) {
        	maps[i] = new HashMap<>();
        	int num = A[i];
        	for (int j = 0; j < i; j++) {
        		if ((long) num - A[j] > Integer.MAX_VALUE) continue;
        		if ((long) num - A[j] < Integer.MIN_VALUE) continue;
        		int diff = num - A[j];
        		int count = maps[j].getOrDefault(diff, 0);
        		maps[i].put(diff, maps[i].getOrDefault(diff, 0) + count + 1);
        		res += count;
        	}
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = new int[]{2, 4, 6, 8, 10};
		System.out.println(numberOfArithmeticSlices(test));
		
	}

}

package hashtable;

import java.util.Arrays;

/**
 * 274. H-Index
 * @author yutian
 * @since Sep 24, 2015
 */
public class HIndex {
	
	// Solution 1: Extra space
	public static int hIndex(int[] citations) {
		int n = citations.length;
		if (n == 0) return 0;
		int[] d = new int[n + 1];
		for (int c : citations) {
			if (c > n) d[n]++;
			else d[c]++;
		}
		
		int t = 0;
		for (int i = n; i >= 0; i--) {
			t += d[i];
			if (t >= i) return i;
		}
		return 0;
	}
	
	// Solution 2: Sort
	public static int hIndex2(int[] citations) {
		Arrays.sort(citations);
		int h = 0, i = citations.length;
		for (int c : citations) {
			if (c > --i) h++;
		}
		return h;
	}

	public static void main(String[] args) {
		System.out.println(hIndex2(new int[]{ 3, 0, 6, 1, 5 })); // output -> 3
		System.out.println(hIndex2(new int[]{ 1 })); // output -> 1
	}
	
}

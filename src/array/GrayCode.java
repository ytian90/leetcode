package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 89. Gray Code
 * @author yutian
 * @since Aug 20, 2015
 */
public class GrayCode {
	/**
	 * Time ~O(N^2), Space ~O(1)
	 * n = 1: 0 | 1
	 * n = 2: 00 01 | 11 10
	 * n = 3: 000 001 011 010 | 110 111 101 100
	 * bar left: each item from previous line with 0 added in front of it from left to right
	 * bar right: each item from previous line with 1 added in front of it from right to left
	 * @param n
	 * @return
	 */
	public static List<Integer> grayCode(int n) {
		List<Integer> list = new ArrayList<>();
		list.add(0);
		for (int i = 0; i < n; i++) {
			int flipper = 1 << i;
			for (int j = list.size() - 1; j >= 0; j--) { // scan the previous sequence backward
				list.add(list.get(j) | flipper); // flip the current highest bit from 0 to 1
			}
		}
		return list;
	}
	
	/**
	 * DFS
	 * @param n
	 * @return
	 */
	public static List<Integer> grayCode2(int n) {
		List<Integer> list = new ArrayList<>();
		list.add(0);
		dfs(0, n, list);
		return list;
	}

	private static void dfs(int i, int n, List<Integer> list) {
		if (i == n) return;
		else {
			int flipper = 1 << i;
			for (int j = list.size() - 1; j >= 0; j--) {
				list.add(list.get(i) | flipper);
			}
			dfs(i + 1, n, list);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(grayCode(3));
	}
}

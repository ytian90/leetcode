package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 118. Pascal's Triangle
 * @author yutian
 * @since Aug 6, 2015
 */
public class PascalsTriangle {
	
	public static void main(String[] args) {
		List<List<Integer>> result = generate2(5);
		for (List<Integer> l : result) {
			System.out.println(l);
		}
	}
	
	// Solution 1 Time ~O(N), Space ~O(N^2)
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 0; i < numRows; i++) {
			List<Integer> list = new ArrayList<Integer>(Arrays.asList(1));
			for (int j = 1; j < i; j++) {
				list.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
			}
			if (i > 0) list.add(1);
			result.add(list);
		}
		return result;
	}
	
	// Solution 2
	public static List<List<Integer>> generate2(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		ArrayList<Integer> row = new ArrayList<Integer>();
		for (int i = 0; i < numRows; i++) {
			row.add(0, 1);
			for (int j = 1; j < row.size() - 1; j++) {
				row.set(j, row.get(j) + row.get(j + 1));
			}
			result.add(new ArrayList<Integer>(row));
		}
		return result;
	}
	
}

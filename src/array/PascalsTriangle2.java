package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Pascal's Triangle II
 * @author yutian
 * @since Aug 9, 2015
 */
public class PascalsTriangle2 {
	public static List<Integer> getRow(int rowIndex) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (rowIndex < 0) {
			return result;
		}
		result.add(1);
		for (int i = 0; i < rowIndex; i++) {
			for (int j = result.size() - 2; j >= 0; j--) {
				result.set(j + 1, result.get(j) + result.get(j + 1));
			}
			result.add(1);
		}
		return result;
	}
	public static void main(String[] args)
	{
		System.out.println(getRow(4));
	}
}

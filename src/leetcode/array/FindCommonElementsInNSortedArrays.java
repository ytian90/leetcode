package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Find Common elements in N sorted nums
 * http://stackoverflow.com/questions/15036821/find-common-elements-in-n-sorted-nums-with-no-extra-space
 * @author yutian
 *
 */
public class FindCommonElementsInNSortedArrays {
	
	public List<Integer> find(int[][] nums) {
		int baseIndex = 0, currIndex = 0, totalMatch = 0;
		int[] indices = new int[nums.length - 1];
		boolean smallestArrayTraversed = false;
		List<Integer> res = new ArrayList<>();
		while (!smallestArrayTraversed && baseIndex < nums[0].length) {
			totalMatch = 0;
			for (int i = 1; i < nums.length; i++) {
				currIndex = indices[i - 1];
				while (currIndex < nums[i].length && nums[i][currIndex] < nums[0][baseIndex]) {
					currIndex++;
				}
				if (currIndex < nums[i].length) {
					if (nums[i][currIndex] == nums[0][baseIndex]) {
						totalMatch++;
					}
				} else {
					smallestArrayTraversed = true;
				}
				indices[i - 1] = currIndex;
			}
			if (totalMatch == nums.length - 1) {
				res.add(nums[0][baseIndex]);
			}
			baseIndex++;
		}
		return res;
	}

	public static void main(String[] args) {
		FindCommonElementsInNSortedArrays sol = new FindCommonElementsInNSortedArrays();
		int[][] arr = { {1, 5, 10, 20, 40, 80},
                {6, 7, 20, 80, 100},
                {3, 4, 15, 20, 30, 70, 80, 120}
               };
		List<Integer> res = sol.find(arr);
		System.out.println(res);
	}

}

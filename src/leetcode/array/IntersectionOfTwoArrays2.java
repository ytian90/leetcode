package leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 350. Intersection of Two Arrays 2
 * @author yutian
 * @since May 28, 2016
 */
public class IntersectionOfTwoArrays2 {
	
	public int[] intersect(int[] nums1, int[] nums2) {
		if (nums1.length == 0 || nums2.length == 0) {
			return new int[]{};
		}
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> res = new ArrayList<>();
		for (int n : nums1) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		for (int n : nums2) {
			if (map.containsKey(n)) {
				res.add(n);
				map.put(n, map.get(n) - 1);
				if (map.get(n) == 0) {
					map.remove(n);
				}
			}
		}
		int[] ans = new int[res.size()];
		for (int i = 0; i < ans.length; i++) {
			ans[i] = res.get(i);
		}
		return ans;
    }

	public static void main(String[] args) {
		int[] t1 = new int[]{1, 2, 2, 1};
		int[] t2 = new int[]{2, 2};
		IntersectionOfTwoArrays2 t = new IntersectionOfTwoArrays2();
		for (int i : t.intersect(t1, t2)) {
			System.out.print(i + " ");
		}
	}

}

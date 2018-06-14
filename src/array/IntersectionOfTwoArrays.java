package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

/**
 * 349. Find Same Numbers in Pairs from Two Arrays
 * @author yutian
 * @since Jan 28, 2016
 */
public class IntersectionOfTwoArrays {
	
	// use two has sets time : O(N)
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
		Set<Integer> res = new HashSet<>();
		for (int i = 0; i < nums1.length; i++) {
			set.add(nums1[i]);
		}
		for (int i = 0; i < nums2.length; i++) {
			if (set.contains(nums2[i])) {
				res.add(nums2[i]);
			}
		}
		return res.stream().mapToInt(i->i).toArray();
	}
	
	// sort both arrays, two pointers O(nlogn)
	public int[] intersection2(int[] nums1, int[] nums2) {
		Set<Integer> res = new HashSet<>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i = 0, j = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				i++;
			} else if (nums1[i] > nums2[j]) {
				j++;
			} else {
				res.add(nums1[i]);
				i++; j++;
			}
		}
		return res.stream().mapToInt(t->t).toArray();
	}
	
	// binary search time 
	public int[] intersection3(int[] nums1, int[] nums2) {
		Set<Integer> intersect = new HashSet<>();
		Arrays.sort(nums2);
		for (Integer n : nums1) {
			if (Arrays.binarySearch(nums2, n) >= 0) {
				intersect.add(n);
			}
		}
		return intersect.stream().mapToInt(i->i).toArray();
	}
	
	// self implemented binary search
	public boolean binarySearch(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				return true;
			} else if (nums[mid] > target) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return false;
	}
	
	
	
	//  http://www.1point3acres.com/bbs/thread-143059-3-1.html
	public static List<Integer> merge(int[] A, int[] B) {	
		List<Integer> result = new ArrayList<>();
		if (A.length == 0 || B.length == 0) return result;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i: A) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}
		for (int i: B) {
			if (map.containsKey(i)) {
				result.add(i);
				if (map.get(i) - 1 == 0) {
					map.remove(i);
				} else {
					map.put(i, map.get(i) - 1);
				}
			}
		}
		return result;
	}
	
	public static int merge2(int[] A, int[] B) {
		HashSet<Integer> set = new HashSet<>();
		for (int i : A) {
			set.add(i);
		}
		for (int i : B) {
			if (!set.add(i)) return i;
		}
		throw new IllegalArgumentException("No same item");
	}

	public static void main(String[] args) {
//		System.out.println(merge(new int[]{1, 2, 3, 4, 5, 6}, new int[]{4, 4, 5, 6, 7, 8}));
//		System.out.println(merge(new int[]{1, 1, 2, 2, 3}, new int[]{2, 2, 4, 5, 6}));
		
		System.out.println(merge2(new int[]{2, 5, 3, 6, 10}, new int[]{7, 33, 4, 2}));
	}

}

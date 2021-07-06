package company.uuba;

import java.util.*;

/**
 * LC 350. Intersection of Two Arrays II
 *
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Explanation: [9,4] is also accepted.
 *
 *
 * Constraints:
 *
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 *
 *
 * Follow up:
 *
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[]{};
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for (int n : nums2) {
            if (map.containsKey(n) && map.get(n) > 0) {
                res.add(n);
                map.put(n, map.get(n) - 1);
            }
        }
        int[] r = new int[res.size()];
        int index = 0;
        for (int i : res) {
            r[index++] = i;
        }
        return r;
    }

    // follow up 1: What if the given array is already sorted? How would you optimize your algorithm?
    public int[] intersect2(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[list.size()];
        int k = 0;
        for (Integer num : list) {
            result[k++] = num;
        }
        return result;
    }

    /**
     * follow up 2: What if nums1's size is small compared to nums2's size? Which algorithm is better?
     * binary search the nums2
     *
     * follow up 3: What if elements of nums2 are stored on disk, and the memory is limited such that you cannot
     * load all elements into the memory at once?
     * If only nums2 cannot fit in memory, put all elements of nums1 into a HashMap, read chunks of array that fit
     * into the memory, and record the intersections.
     * If both nums1 and nums2 are so huge that neither fit into the memory, sort them individually (external sort),
     * then read 2 elements from each array at a time in memory, record intersections.

     * 1. Store the two strings in distributed system(whether self designed or not), then using MapReduce technique to solve the problem;
     * 2. Processing the Strings by chunk, which fits the memory, then deal with each chunk of data at a time;
     * 3. Processing the Strings by streaming, then check.
     */
}

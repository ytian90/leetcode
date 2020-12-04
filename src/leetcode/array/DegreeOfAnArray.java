package leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 697. Degree of an Array
 */
public class DegreeOfAnArray {

    public static int findShortestSubArray(int[] nums) {
        if (nums.length == 0 || nums == null)
            return 0;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                // {degree, first index, last index}
                map.put(nums[i], new int[]{1, i, i});
            } else {
                int[] t = map.get(nums[i]);
                t[0]++;
                t[2] = i;
            }
        }
        int degree = Integer.MIN_VALUE, res = Integer.MAX_VALUE;
        for (int[] value : map.values()) {
            if (value[0] > degree) {
                degree = value[0];
                res = value[2] - value[1] + 1;
            } else if (value[0] == degree) {
                res = Math.min(res, value[2] - value[1] + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
        System.out.println(findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}));
    }
}

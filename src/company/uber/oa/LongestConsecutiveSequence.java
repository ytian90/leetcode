package company.uber.oa;

import java.util.HashSet;
import java.util.Set;

/**
 * 盖房子，输出最大连续房子的个数。并查集，不需要压缩路径也能过。
 * 就是leetcode 128原题
 */
public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int res = 0;
        for (int n : nums) {
            if (!set.contains(n - 1)) {
                int j = n;
                int count = 0;
                while (set.contains(j)) {
                    count++;
                    j++;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }

}

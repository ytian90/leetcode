package leetcode.dfs_bfs;

import java.util.*;

/**
 * 491. Increasing Subsequences
 */
public class IncreasingSubsequences {
    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        helper(nums, 0, list, res);
        return res;
    }

    private static void helper(int[] nums, int start, LinkedList<Integer> list, List<List<Integer>> res) {
        if (list.size() > 1) res.add(new ArrayList<>(list));
        Set<Integer> visited = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (visited.contains(nums[i])) continue;
            if (list.size() == 0 || nums[i] >= list.peekLast()) {
                visited.add(nums[i]);
                list.add(nums[i]);
                helper(nums, i + 1, list, res);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(findSubsequences(new int[]{4, 6, 7, 7}));
    }
}

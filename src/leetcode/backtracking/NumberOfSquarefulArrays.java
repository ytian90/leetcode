package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfSquarefulArrays {

    public static int numSquarefulPerms(int[] A) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int count = 0;
        Arrays.sort(A);
        helper(A, list, res, new boolean[A.length]);
        for (List<Integer> l : res) {
            if (isSquareful(l)) {
                count++;
            }
        }
        return count;
    }

    public static void helper(int[] nums, List<Integer> list, List<List<Integer>> res, boolean[] visited) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            helper(nums, list, res, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

    public static boolean isSquareful(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            double sum = list.get(i - 1) + list.get(i);
            if (!isSquareful(sum)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSquareful(double n) {
        double sqrt = Math.sqrt(n);
        return (sqrt - Math.floor(sqrt)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(numSquarefulPerms(new int[]{1, 17, 8}));
        System.out.println(numSquarefulPerms(new int[]{2, 3, 1}));
        System.out.println(numSquarefulPerms(new int[]{65, 44, 5, 11}));
    }
}

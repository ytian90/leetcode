package leetcode.mj.google;

import java.util.TreeSet;

/**
 * lc363
 * https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=568082&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3086%5D%5Bvalue%5D%3D9%26searchoption%5B3086%5D%5Btype%5D%3Dradio%26searchoption%5B3089%5D%5Bvalue%5D%5B3%5D%3D3%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D1%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
 */
public class MaxSumOfRectangleNoLargerThanK {

    public static int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix.length == 0) {
            return 0;
        }
        int n = matrix.length, m = matrix[0].length;
        int res = Integer.MIN_VALUE;
        for (int left = 0; left < m; left++) {
            int[] sums = new int[n];
            for (int right = left; right < m; right++) {
                for (int i = 0; i < n;  i++) {
                    sums[i] += matrix[i][right];
                }
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                int currSum = 0;
                for (int sum : sums) {
                    currSum += sum;
                    Integer num = set.ceiling(currSum - k);
                    if (num != null) {
                        res = Math.max(res, currSum - num);
                    }
                    set.add(currSum);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxSumSubmatrix(new int[][]{{1, 0, 1}, {0, -2, 3}}, 2));
    }
}

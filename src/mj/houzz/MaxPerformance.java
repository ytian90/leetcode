package mj.houzz;

import java.util.*;

// # In Palo Alto, there are m homeowners want to do kitchen remodeling,
// # and there are n professionals can help them.
// # There is a matching score between different homeowners and professionals
// # Each professional can take at most k (k >= 1) projects at the moment
// # and we can assume all homeowners can be matched with a pro (m <= n*k)

// # Find the max(total matching score) for m homeowners

// # example input matching metrics
// #     pro1    pro2    pro3
// # h1   3       2        1
// # h2   2       3        1
// # h3   3       1        2


// #    pro1    pro2    pro3
// # h1 100      99        1
// # h2  98       3        1
// # h3   3       1        2


// # if k == 1, the max scroe is 3 + 3 + 2 = 8
// # if k == 2, the max score is 3 + 3 + 3 = 9

class MaxPerformance {
    static int max = 0;

    public static void main(String[] args) {
        int[][] t = new int[][]{
                {3, 2, 1},
                {2, 3, 1},
                {3, 1, 2}
        };
        System.out.println(maxPerformance(t, 1));
        System.out.println(maxPerformance(t, 2));
        int[][] t2 = new int[][]{
                {100, 99, 1},
                {98, 3, 1},
                {3, 1, 2}
        };
        System.out.println(maxPerformance(t2, 1));
    }

    public static int maxPerformance(int[][] matrix, int k) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix[0].length;
        int[] pros = new int[m];
        Arrays.fill(pros, k);
        backtracking(matrix, 0, pros, 0, 0);
        return max;
    }

    public static void backtracking(int[][] matrix, int sum, int[] pros, int row, int col) {
        if (row == matrix.length) {
            max = Math.max(max, sum);
            return;
        }
        for (int j = col; j < matrix[0].length; j++) {
            if (pros[j] > 0) {
                sum += matrix[row][j];
                pros[j]--;
                backtracking(matrix, sum, pros, row + 1, 0);
                sum -= matrix[row][j];
                pros[j]++;
            }
        }
    }
}

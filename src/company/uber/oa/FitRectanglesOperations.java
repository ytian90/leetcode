package company.uber.oa;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/discuss/interview-question/949185/uber-sde-1-us-codesignal-oa
 *
 * You are given an array consisting of 2 types of operations.
 * [0,a,b] - Create and save a rectangle of size axb
 * [1,a,b] - check whether every PREVIOUS saved rectangle can be fit inside this rectangle of axb. You can rotate rectangles by 90 degrees. We try to fit each rectangle ONE AT A TIME and not TOGETHER.
 * Return an array of booleans representing answers to second operation in the order in which they appear.
 * ex.
 * operations = [1,1,1]
 * output = [true]
 * No rectangles saved so they can fit inside anything.
 *
 * ex.
 * operations = [[0,1,3], [0,4,2], [1,3,4], [1,3,2]]
 * output = [true,false]
 * [1,3] and [4,2](rotated) can fit inside [3,4] so true
 * [1,3] can fit but [4,2] cannot fit inside [3,2] so false.
 */
public class FitRectanglesOperations {
    public static List<Boolean> fit(int[][] operations) {
        List<int[]> saved = new ArrayList<>();
        List<Boolean> res = new ArrayList<>();
        for (int[] op : operations) {
            if (op[0] == 0) {
                saved.add(new int[]{op[1], op[2]});
            } else if (op[0] == 1) {
                if (saved.isEmpty()) {
                    res.add(true);
                } else {
                    boolean fit = true;
                    for (int[] prev : saved) {
                        if (!fit(prev, new int[]{op[1], op[2]})) {
                            fit = false;
                        }
                    }
                    res.add(fit);
                }
            }
        }
        return res;
    }

    private static boolean fit(int[] prev, int[] curr) {
        return prev[0] <= curr[0] && prev[1] <= curr[1] || prev[0] <= curr[1] && prev[1] <= curr[0];
    }

    public static void main(String[] args) {
        System.out.println(fit(new int[][]{
                {0,1,3}, {0,4,2}, {1,3,4}, {1,3,2}
        }));
    }

}

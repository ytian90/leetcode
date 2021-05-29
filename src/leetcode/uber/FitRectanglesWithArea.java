package leetcode.uber;

import java.util.ArrayList;
import java.util.List;

/**
 * Got this question in CodeSignal and not sure how to solve it.
 *
 * You are given an array containing "rectangles" where each rectangle is in the form [l, w] where l is its length and w is its width.
 * You are also given x and y which represent the width and height of the area you are attempting to put all the rectangles in.
 * The rectangles can be rotated before inserted. Return True or False if all the rectangles can be put into the area.
 *
 * Example:
 *
 * rectangles = [[4, 2], [2,3]]
 * x = 3
 * y = 6
 *
 * returns True
 * Explanation:
 * let a, b = rectangle r1, rectangle r2
 *
 * [[a, a, 0]
 * [a, a, 0]
 * [a, a, 0]
 * [a, a, 0]
 * [b, b, b]
 * [b, b, b]
 * ]
 *
 * is an example of how the rectangles can be rotated and fit within the target area. Therefore, the function returns True.
 *
 * https://leetcode.com/discuss/interview-question/859964/robinhood-codesignal-oa-fit-rectangles-within-area
 */
public class FitRectanglesWithArea {
    static List<List<int[]>> figureDimension;
    static List<List<int[]>> rotatedFigureDimension;

    public static boolean fit(int[][] rectangles, int x, int y) {
        generateFigureDimension(rectangles);
        int[][] matrix = new int[x][y];
        boolean[] visited = new boolean[rectangles.length];
        int rectangleId = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (matrix[i][j] == 0) {
                    int scenario = isValid(matrix, i, j, rectangleId);
                    if (scenario != 3) {
                        dfs(matrix, i, j, visited, rectangleId, scenario);
                    }
                }
            }
        }

        for (List<int[]> figure : figureDimension) {
            int figureId = 1;

        }
        return true;
    }

    private static int dfs(int[][] matrix, int i, int j, boolean[] visited, int rectangleId, int scenario) {
        return 0;
    }

    // 0 - figure dimension works, 1 - rotated figure dimension works, 2 - both work, 3 - nothing works
    private static int isValid(int[][] matrix, int i, int j, int rectangleId) {
        int zeroCount = 0, zeroCountRotated = 0;
        for (int[] a : figureDimension.get(rectangleId)) {
            int x = i + a[0], y = j + a[1];
            if (matrix[x][y] == 0) {
                zeroCount++;
            }
        }
        for (int[] a : rotatedFigureDimension.get(rectangleId)) {
            int x = i + a[0], y = j + a[1];
            if (matrix[x][y] == 0) {
                zeroCountRotated++;
            }
        }
        boolean figureWorks = zeroCount == figureDimension.get(rectangleId).size();
        boolean rotatedFigureWorks = zeroCountRotated == rotatedFigureDimension.get(rectangleId).size();
        if (figureWorks && !rotatedFigureWorks) {
            return 0;
        } else if (!figureWorks && rotatedFigureWorks) {
            return 1;
        } else if (figureWorks && rotatedFigureWorks) {
            return 2;
        } else {
            return 3;
        }
    }

    private static void generateFigureDimension(int[][] rectangles) {
        figureDimension = new ArrayList<>();
        rotatedFigureDimension = new ArrayList<>();
        for (int[] rec : rectangles) {
            List<int[]> list = new ArrayList<>();
            List<int[]> rotateList = new ArrayList<>();
            for (int i = 0; i < rec[0]; i++) {
                for (int j = 0; j < rec[1]; j++) {
                    list.add(new int[]{i, j});
                    rotateList.add(new int[]{j, i});
                }
            }
            figureDimension.add(list);
            rotatedFigureDimension.add(rotateList);
        }
    }

    public static void main(String[] args) {
        System.out.println(fit(new int[][]{{4, 2}, {2, 3}}, 3, 6));
    }

}

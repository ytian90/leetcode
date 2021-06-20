package company.uuba;

import java.util.Arrays;

/**
 * LC 1861. Rotating the Box
 *
 * You are given an m x n matrix of characters box representing a side-view of a box. Each cell of the box is one of the following:
 *
 * A stone '#'
 * A stationary obstacle '*'
 * Empty '.'
 * The box is rotated 90 degrees clockwise, causing some of the stones to fall due to gravity. Each stone falls down until it lands on an obstacle, another stone, or the bottom of the box. Gravity does not affect the obstacles' positions, and the inertia from the box's rotation does not affect the stones' horizontal positions.
 *
 * It is guaranteed that each stone in box rests on an obstacle, another stone, or the bottom of the box.
 *
 * Return an n x m matrix representing the box after the rotation described above.
 *
 * Example 1:
 *
 * Input: box = [['#','.','#']]
 * Output: [['.'],
 *          ['#'],
 *          ['#']]
 * Example 2:
 *
 * Input: box = [['#','.','*','.'],
 *               ['#','#','*','.']]
 * Output: [['#','.'],
 *          ['#','#'],
 *          ['*','*'],
 *          ['.','.']]
 * Example 3:
 *
 * Input: box = [['#','#','*','.','*','.'],
 *               ['#','#','#','*','.','.'],
 *               ['#','#','#','.','#','.']]
 * Output: [['.','#','#'],
 *          ['.','#','#'],
 *          ['#','#','*'],
 *          ['#','*','.'],
 *          ['#','.','*'],
 *          ['#','.','.']]
 */
public class RotatingTheBox {
    public static char[][] rotateTheBox(char[][] box) {
        int n = box.length, m = box[0].length;
        char[][] res = new char[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = m - 1, k = m - 1; j >= 0; j--) {
                res[j][n - 1 - i] = '.';
                if (box[i][j] != '.') {
                    if (box[i][j] == '*') {
                        k = j;
                    }
                    res[k--][n - 1 - i] = box[i][j];
                }
            }
        }
        return res;
    }

    /**
     * Time: O(N * M)
     * Space: O(N * M)
     * n - 1 - i is the tricky part for rotate 90
     */

    public static void main(String[] args) {
        for (char[] c : rotateTheBox(new char[][]{
                {'#','.','*','.'},{'#','#','*','.'}
        })) {
            System.out.println(Arrays.toString(c));
        }
    }

}

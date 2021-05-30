package company.uber.oa;

import java.util.Arrays;

/**
 * You are given a matrix of characters representing a big board. Each cell of the matrix contains one of three characters:
 * '.', which means that the cell is empty;
 * '*', which means that the cell contains an obstacle;
 * '#', which means that the cell contains a small box.
 *
 * first step: 把 “#”box全部推到最右边
 * second step: 把 “#”box全部推到最下边
 * 返回最终的状态
 *
 * example1:
 *
 * board= [['#', '#', '.', '.', '.', '.', '.'],
 *         ['#', '#', '#', '.', '.', '.', '.'],
 *         ['#', '#', '#', '.', '.', '#', '.']]
 *
 * output board = [['.', '.', '.', '.', '.', '#', '#'],
 *                 ['.', '.', '.', '.', '#', '#', '#'],
 *                 ['.', '.', '.', '#', '#', '#', '#']]
 *
 * example2:
 *
 * board= [['#', '.', '.', '.', '*', '.', '.'],
 *         ['.', '#', '.', '*', '.', '#', '.'],
 *         ['#', '*', '#', '.', '.', '#', '.']]
 *
 * output board = [['.', '.', '.', '#', '*', '.', '.'],
 *                 ['.', '.', '.', '*', '.', '.', '#'],
 *                 ['#', '*', '#', '.', '.', '#', '#']]
 * 我分了两步，第一步是处理往右推：每一行从右往左处理，如果当前是箱子而且能往右推，就推到最右，然后当前位改成'.'。第二部是处理往下推，和第一步类似。
 */
public class PushBoxToRightBottomCorner {
    public static void push(char[][] matrix) {
        pushRight(matrix);
        pushDown(matrix);
    }

    private static void pushRight(char[][] matrix) {
        for (char[] row : matrix) {
            pushRowRight(row);
        }
    }

    private static void pushRowRight(char[] row) {
        int mostRight = row.length, n = row.length;
        for (int i = n - 1; i >= 0; i--) {
            if (row[i] == '*') {
                mostRight = i;
            } else if (row[i] == '#') {
                row[--mostRight] = '#';
                if (mostRight != i) {
                    row[i] = '.';
                }
            }
        }
    }

    private static void pushDown(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        for (int j = 0; j < m; j++) {
            int mostBottom = n;
            for (int i = matrix.length - 1; i >= 0; i--) {
                if (matrix[i][j] == '*') {
                    mostBottom = i;
                } else if (matrix[i][j] == '#') {
                    matrix[--mostBottom][j] = '#';
                    if (mostBottom != i) {
                        matrix[i][j] = '.';
                    }

                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] t1 = new char[][]{
                {'#', '.', '.', '.', '*', '.', '.'},
                {'.', '#', '.', '*', '.', '#', '.'},
                {'#', '*', '#', '.', '.', '#', '.'}
        };
        push(t1);
        for (char[] c : t1) {
            System.out.println(Arrays.toString(c));
        }
        System.out.println();
        char[][] t2 = new char[][]{
                {'#', '#', '.', '.', '.', '.', '.'},
                {'#', '#', '#', '.', '.', '.', '.'},
                {'#', '#', '#', '.', '.', '#', '.'}
        };
        push(t2);
        for (char[] c : t2) {
            System.out.println(Arrays.toString(c));
        }
    }
}

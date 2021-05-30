package company.uber.oa;

import java.util.ArrayList;
import java.util.List;

/**
 * 第三题是老题， 题干很长， 大意是给一个matrix, 从左下开始斜着print， 每组print的string要填充至matrix的长度。 最后找到每组string排序后的index, return
 * [ ['a','b'],
 *   ['c', d']]
 * -> [['c'], ['a','b'], ['b']]
 * -> ['cc', 'ab', 'bb'] # 如果sort, ['ab', 'bb', 'cc']
 * -> [3, 1, 2]
 */
public class printCharDiagonalPaddingSort {

    public static int[] index(char[][] matrix) {
        List<String> list = new ArrayList<>();
        return null;
    }

    public static void diagonalOrder(char[][] matrix) {
        List<List<Character>> list = new ArrayList<>();
        int n = matrix.length, m = matrix[0].length;
        for (int line = 1; line < (n + m - 1); line++) {
            List<Character> l = new ArrayList<>();
            int startCol = Math.max(0, line - n);
            int count = Math.min(line, Math.min(m - startCol, n));
            for (int j = 0; j < count; j++) {
                l.add(matrix[Math.min(0, line) + j - 1][startCol + j]);
            }
        }
        System.out.println(list);
    }

    public static void main(String[] args) {
        diagonalOrder(new char[][]{
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'}
        });
    }
}

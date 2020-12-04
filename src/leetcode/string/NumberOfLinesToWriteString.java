package leetcode.string;

import java.util.Arrays;

/**
 * 806. Number of Lines To Write String
 */
public class NumberOfLinesToWriteString {
    public static int[] numberOfLines(int[] widths, String S) {
        int[] res = {0, 0};
        if (S == null || S.length() == 0) {
            return res;
        }
        int lastLineLength = 0;
        int lineCount = 1;
        for (char c : S.toCharArray()) {
            int wordLength = widths[c - 'a'];
            if (lastLineLength + wordLength > 100) {
                lineCount++;
                lastLineLength = wordLength;
            } else {
                lastLineLength += wordLength;
            }
        }
        res[0] = lineCount;
        res[1] = lastLineLength;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(numberOfLines(new int[]{
                10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10
        }, "abcdefghijklmnopqrstuvwxyz")));

        System.out.println(Arrays.toString(numberOfLines(new int[]{
                4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10
        }, "bbbcccdddaaa")));
    }
}

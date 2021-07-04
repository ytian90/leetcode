package company.uuba;

/**
 * LC 6. ZigZag Conversion
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 *
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * Example 3:
 *
 * Input: s = "A", numRows = 1
 * Output: "A"
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }
        int i = 0;
        while (i < len) {
            for (int j = 0; j < numRows && i < len; j++) {
                sb[j].append(c[i++]);
            }
            for (int j = numRows - 2; j >= 1 && i < len; j--) {
                sb[j].append(c[i++]);
            }
        }
        for (int j = 1; j < sb.length; j++) {
            sb[0].append(sb[j]);
        }
        return sb[0].toString();
    }
    /**
     * Time: O(N)
     * Space: O(N)
     */
}

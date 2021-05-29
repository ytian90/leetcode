package leetcode.uber;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个2d string array 里面每个 string array都有 文字， 再个一个 width 需要输出一个center align的String array（解释比较复杂，看example）类似lc 68
 * 输出[["Hello", "World"], ["You"], ["Are", "beautiful", "U", "canDoThis"]]  width = 16
 * 输出       [["******************"],
 *             ["*  Hello World   *"].
 *             ["*         You    *"],
 *             ["*Are beautiful U *"],
 *             ["*     canDoThis  *"]，
 *             ["******************"]]
 * 每个string array都算一行，如果里面的单词length 加上空格多于width就得新启一行 “*”不计算在width内
 * https://leetcode.com/problems/text-justification/submissions/
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int left = 0;
        while (left < words.length) {
            int right = findRight(left, words, maxWidth);
            res.add(justify(left, right, words, maxWidth));
            left = right + 1;
        }
        return res;
    }

    private int findRight(int left, String[] words, int maxWidth) {
        int right = left;
        int sum = words[right++].length();
        while (right < words.length && (sum + 1 + words[right].length()) <= maxWidth) {
            sum += 1 + words[right++].length();
        }
        return right - 1;
    }

    private String justify(int left, int right, String[] words, int maxWidth) {
        if (right - left == 0) {
            return padResult(words[left], maxWidth);
        }
        boolean isLastLine = right == words.length - 1;
        int numWords = right - left;
        int numWhiteSpace = maxWidth - wordsLen(left, right, words);
        String space = isLastLine ? " " : blank(numWhiteSpace / numWords);
        int remainder = isLastLine ? 0 : numWhiteSpace % numWords;
        StringBuilder sb = new StringBuilder();
        for (int i = left; i <= right; i++) {
            sb.append(words[i])
                    .append(space)
                    .append(remainder-- > 0 ? " " : "");
        }
        return padResult(sb.toString().trim(), maxWidth);
    }

    private int wordsLen(int left, int right, String[] words) {
        int res = 0;
        for (int i = left; i <= right; i++) {
            res += words[i].length();
        }
        return res;
    }

    private String padResult(String result, int maxWidth) {
        return result + blank(maxWidth - result.length());
    }

    private String blank(int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}

package leetcode.mj.airbnb;

import java.util.LinkedList;
import java.util.List;

/**
 * 12. Text Justification
 */
public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new LinkedList<String>();
        for (int i = 0, w; i < words.length; i = w) {
            int len = -1;
            for (w = i; w < words.length && len + words[w].length() + 1 <= maxWidth; w++) { // test2
                len += words[w].length() + 1; // test4
            }
            StringBuilder sb = new StringBuilder(words[i]);
            int space = 1, extra = 0;
            if (w != i + 1 && w != words.length) { // w != i + 1 to make denominator non-zero
                space = (maxWidth - len) / (w - i - 1) + 1; // w - i - 1 -> test2, + 1 -> test4
                extra = (maxWidth - len) % (w - i - 1); // test1
            }
            for (int j = i + 1; j < w; j++) {
                for (int s = space; s > 0; s--) sb.append(' ');
                if (extra-- > 0) sb.append(' '); // not while -> test5
                sb.append(words[j]);
            }
            int rest = maxWidth - sb.length(); // not len -> test2
            while (rest-- > 0) sb.append(' ');
            res.add(sb.toString());
        }
        return res;
    }

}

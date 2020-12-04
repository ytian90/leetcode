package leetcode.string;

import java.util.LinkedList;
import java.util.List;

/**
 * 68. Text Justification
 * @author yutian
 * @since Aug 31, 2015
 */
public class TextJustification {
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> res = new LinkedList<String>();
		for (int i = 0, cwi; i < words.length; i = cwi) {
			int len = -1;
			for (cwi = i; cwi < words.length && len + words[cwi].length() + 1 <= maxWidth; cwi++) { // test2
				len += words[cwi].length() + 1; // test4
			}
			StringBuilder sb = new StringBuilder(words[i]);
			int space = 1, extra = 0;
			if (cwi != i + 1 && cwi != words.length) { // w != i + 1 to make denominator non-zero
				space = (maxWidth - len) / (cwi - i - 1) + 1; // w - i - 1 -> test2, + 1 -> test4
				extra = (maxWidth - len) % (cwi - i - 1); // test1
			}
			for (int j = i + 1; j < cwi; j++) {
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
	
	public static void main(String[] args) {
		TextJustification t = new TextJustification();
		String[] test = {"This", "is", "an", "example", "of", "text", "justification."};
		System.out.println(t.fullJustify(test, 16));
		
		String[] test2 = {"Listen","to","many,","speak","to","a","few."};
		System.out.println(t.fullJustify(test2, 6));
		
		String[] test3 = {"a","b","c,","d","e"};
		System.out.println(t.fullJustify(test3, 2));
		
		String[] test4 = {"a","b","c,","d","e"};
		System.out.println(t.fullJustify(test4, 3));
		
		String[] test5 = {"Don't","go","around","saying","the","world",
				"owes","you","a","living;","the","world","owes","you",
				"nothing;","it","was","here","first."};
		System.out.println(t.fullJustify(test5, 30));
	}
}

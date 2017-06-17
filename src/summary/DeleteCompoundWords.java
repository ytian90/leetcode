package summary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * http://www.1point3acres.com/bbs/thread-166984-1-1.html
 * @author yutian
 * @since Apr 2, 2016
 */
public class DeleteCompoundWords {
	
	public Set<String> deleteCompound(ArrayList<String> words) {
		Set<String> res = new HashSet<>();
		Set<String> dict = new HashSet<>(words);
		for (String s : words) {
			dict.remove(s);
			if (!isCompoundWord(s, dict)) res.add(s);
			dict.add(s);
		}
		return res;
	}
	
	boolean isCompoundWord(String s, Set<String> dict) {
		int n = s.length();
		boolean[] dp = new boolean[n + 1];
		dp[0] = true;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] == true && dict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		DeleteCompoundWords t = new DeleteCompoundWords();
		ArrayList<String> words = new ArrayList<>
		(Arrays.asList("whatsoever", "so", "what", "ever", "person", "per", "son"));
		for (String s: t.deleteCompound(words)) {
			System.out.println(s);
		}
	}

}

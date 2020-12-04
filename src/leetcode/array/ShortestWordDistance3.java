package leetcode.array;
/**
 * 245. Shortest Word Distance III
 * @author yutian
 * @since Dec 28, 2015
 */
public class ShortestWordDistance3 {
	
	public static int shortestWordDistance(String[] words, String word1, String word2) {
		int m = -1, n = -1, min = Integer.MAX_VALUE;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
				m = i;
			}
			if (words[i].equals(word2)) {
				if (word1.equals(word2)) m = n;
				n = i;
			}
			if (m != -1 && n != -1) {
				min = Math.min(min, Math.abs(m - n));
			}
		}
		return min;
	}

	public static void main(String[] args) {
		String[] t = new String[]{"a", "a", "b", "a"};
		System.out.println(shortestWordDistance(t, "a", "a"));
	}

}

package leetcode.array;
/**
 * 243. Shortest Word Distance
 * @author yutian
 * @since Dec 27, 2015
 */
public class ShortestWordDistance {
	
	public static int shortestDistance(String[] words, String word1, String word2) {
        int m = -1, n = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                m = i;
            }
            if (words[i].equals(word2)) {
                n = i;
            }
            if (m != -1 && n != -1) {
                min = Math.min(min, Math.abs(m - n));
            }
        }
        return min;
    }

	public static void main(String[] args) {
		String[] t1 = new String[]{"practice", "makes", "perfect", "coding", "makes"};
		System.out.println(shortestDistance(t1, "coding", "practice"));
		System.out.println(shortestDistance(t1, "coding", "makes"));
	}

}

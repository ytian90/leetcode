package leetcode.hashtable;
/**
 * 748. Shortest Completing Word
 * @author ytian
 *
 */
public class ShortestCompletingWord {

	public static String shortestCompletingWord(String licensePlate, String[] words) {
        String target = licensePlate.toLowerCase();
        String res = null;
        int[] chars = new int[26];
        for (char c : target.toCharArray()) {
        		if (Character.isLetter(c)) {
        			chars[c - 'a']++;
        		}
        }
        int min = Integer.MAX_VALUE;
        for (String word : words) {
        		word = word.toLowerCase();
        		if (matches(word, chars) && word.length() < min) {
        			min = word.length();
        			res = word;
        		}
        }
        return res;
    }
	
	private static boolean matches(String word, int[] chars) {
		int[] target = new int[26];
		for (char c : word.toCharArray()) {
			if (Character.isLetter(c)) {
				target[c - 'a']++;
			}
		}
		for (int i = 0; i < 26; i++) {
			if (chars[i] != 0 && target[i] < chars[i]) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}));
		System.out.println(shortestCompletingWord("1s3 456", new String[]{"looks", "pest", "stew", "show"}));
	}
}

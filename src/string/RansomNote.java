package string;
/**
 * 383. Ransom Note
 * cc189: page 71
 * @author yutian
 * @since Aug 31, 2016
 */
public class RansomNote {
	
	public static boolean canConstruct(String ransomNote, String magazine) {
		int[] map = new int[26];
		for (char c : magazine.toCharArray()) {
			map[c - 'a']++;
		}
		for (char c : ransomNote.toCharArray()) {
			if (--map[c - 'a'] < 0) return false;
		}
		return true;
    }

	public static void main(String[] args) {
		System.out.println(canConstruct("a", "b"));
		System.out.println(canConstruct("aa", "ab"));
		System.out.println(canConstruct("aa", "aab"));
	}

}

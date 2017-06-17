package string;
/**
 * 
 * @author yutian
 * @since Aug 31, 2016
 */
public class RansomNote {
	
	public static boolean canConstruct(String ransomNote, String magazine) {
        int[] a = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
        	a[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
        	if (--a[ransomNote.charAt(i) - 'a'] < 0) {
        		return false;
        	}
        }
        return true;
    }

	public static void main(String[] args) {
		System.out.println(canConstruct("a", "b"));
		System.out.println(canConstruct("aa", "ab"));
		System.out.println(canConstruct("aa", "aab"));
	}

}

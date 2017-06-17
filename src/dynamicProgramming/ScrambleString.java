package dynamicProgramming;
/**
 * Scramble String
 * @author yutian
 * @since Nov 8, 2015
 */
public class ScrambleString {
	
	/*
	 * Method 1
	 */
	public static boolean isScramble(String s1, String s2) {
		int len1 = s1.length(), len2 = s2.length();
		if (len1 != len2) return false;
		if (len1 == 0) return true;
		if (s1.equals(s2)) return true;
		int[] count = new int[256];
		for (int i = 0; i < len1; i++) {
			count[s1.charAt(i)]++;
			count[s2.charAt(i)]--;
		}
		for (int i = 0; i < len1; i++) {
			if (count[s1.charAt(i)] != 0) return false;
		}
		for (int i = 1; i < len1; i++) {
			if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))
				return true;
			if (isScramble(s1.substring(0, i), s2.substring(len1 - i)) && isScramble(s1.substring(i), s2.substring(0, len1 - i)))
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(isScramble("great", "rgeat"));
		System.out.println(isScramble("great", "rgtae"));
	}

}

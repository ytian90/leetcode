package string;
/**
 * 520. Detect Capital
 * @author ytian
 *
 */
public class DetectCapital {
	
	/*
	 * A 65, Z 90, a 97, z 122
	 */
	public static boolean detectCapitalUse(String word) {
        int sum = 0;
        for (char c : word.toCharArray()) {
        	if (c <= 'Z') sum++;
        }
        return ((sum == 0 || sum == word.length()) || (sum == 1 && word.charAt(0) <= 'Z'));
    }
	
	public static boolean detectCapitalUse2(String word) {
		return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
	}

	public static void main(String[] args) {
		System.out.println(detectCapitalUse("USA"));
		System.out.println(detectCapitalUse("aFE"));
		System.out.println(detectCapitalUse("aaaef"));
		System.out.println(detectCapitalUse("Aidow"));
	}

}

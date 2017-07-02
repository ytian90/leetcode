package hashtable;
/**
 * Bulls and Cows
 * @author yutian
 * @since Dec 25, 2015
 */
public class BullsAndCows {

	public static void main(String[] args) {
		System.out.println(getHint("1123", "0111"));
	}
	// time O(n)
	public static String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] nums = new int[10];
        for (int i = 0; i < secret.length(); i++) {
        	int s = Character.getNumericValue(secret.charAt(i));
        	int g = Character.getNumericValue(guess.charAt(i));
        	if (s == g) {
        		bulls++;
        	} else {
        		if (nums[s]++ < 0) cows++;
        		if (nums[g]-- > 0) cows++;
        	}
        }
        return bulls + "A" + cows + "B";
    }

}

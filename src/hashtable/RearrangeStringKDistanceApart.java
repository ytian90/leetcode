package hashtable;
/**
 * 358. Rearrange String k Distance Apart
 * @author yutian
 * @since Jul 16, 2016
 */
public class RearrangeStringKDistanceApart {
	
	// Greedy Algorithm
	public static String rearrangeString(String str, int k) {
        int length = str.length();
        int[] count = new int[26];
        int[] valid = new int[26];
        for (int i = 0; i < length; i++) {
        	count[str.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
        	int c = findValidMax(count, valid, i);
        	if (c == -1) return "";
        	count[c]--;
        	valid[c] = i + k;
        	sb.append((char) ('a' + c));
        }
        return sb.toString();
    }	

	private static int findValidMax(int[] count, int[] valid, int index) {
		int max = Integer.MIN_VALUE;
		int c = -1;
		for (int i = 0; i < count.length; i++) {
			if (count[i] > 0 && count[i] > max && index >= valid[i]) {
				max = count[i];
				c = i;
			}
		}
		return c;
		
	}

	public static void main(String[] args) {
		System.out.println(rearrangeString("aabbcc", 3));
		System.out.println(rearrangeString("aaabc", 3));
		System.out.println(rearrangeString("aaadbbcc", 3));
	}

}

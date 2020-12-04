package leetcode.string;
/**
 * Given a leetcode.string, find its first non-repeating character
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=166251&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D2%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D5%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
 * @author yutian
 * @since Jan 19, 2016
 */
public class FirstNonRepeatingCharacter {
	
	public static int getFirstOnceChar(String s) {
		char[] arr = s.toCharArray();
		int[] count = new int[26];
		for (Character c: arr) {
			count[c - 'a']++;
		}
		for (int i = 0 ; i < s.length(); i++) {
            if(count[arr[i]- 'a'] == 1) {
                return i;
            }
        }
		return -1;
	}

	public static void main(String[] args) {
		String t1 = "abacd";
		String t2 = "ababcd";
		System.out.println(getFirstOnceChar(t1));
		System.out.println(getFirstOnceChar(t2));
	}

}

package string;
/**
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=162200&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D2%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D5%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
 * @author yutian
 * @since Jan 6, 2016
 */
public class MoveString {
	
	public static String move(String input, int key) {
		char[] result = input.toCharArray();
		for (int i = 0; i < result.length; i++) {
			char c = result[i];
			if (c >= 'a' && c <= 'z') {
				result[i] = (char) (((c - 'a' + 1) % 26) + 'a');
			} else if (c >= 'A' && c <= 'Z') {
				result[i] = (char) (((c - 'A' + 1) % 26) + 'A');
			}
		}
		return String.valueOf(result);
	}

	public static void main(String[] args) {
		System.out.println(move("xYz", 3));
	}
}

package leetcode.array;
/**
 * Nim Game
 * @author yutian
 * @since Oct 25, 2015
 */
public class NimGame {
	public static boolean canWinNim(int n) {
		return (n % 4 != 0);
	}

	public static void main(String[] args) {
		System.out.println(canWinNim(4));
	}
}

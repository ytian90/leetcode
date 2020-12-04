package leetcode.array;
/**
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=164914&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D2%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D5%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
 * @author yutian
 * @since Jan 8, 2016
 */
public class Sort3Numbers {
	
	public static int[] sort(int a, int b, int c) {
		int max = Math.max(a, Math.max(b, c));
		int min = Math.min(a, Math.min(b, c));
		int mid = a + b + c - max - min;
		return new int[]{min, mid, max};
	}

	public static void main(String[] args) {
		int[] t1 = sort(Integer.MAX_VALUE, 0, -1);
		for (int i: t1) System.out.println(i);
	}

}

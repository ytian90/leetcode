package math;
/**
 * 598. Range Addition II
 * @author ytian
 *
 */
public class RangeAddition2 {
	
	public static int maxCount(int m, int n, int[][] ops) {
        int row = m, col = n;
        for (int[] op : ops) {
        	row = Math.min(row, op[0]);
        	col = Math.min(col, op[1]);
        }
        return row * col;
    }

	public static void main(String[] args) {
		int[][] t = new int[][]{{2, 2}, {3, 3}};
		System.out.println(maxCount(3, 3, t));
	}

}

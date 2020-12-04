package leetcode.array;
/**
 * 566. Reshape the Matrix
 * @author ytian
 *
 */
public class ReshapeTheMatrix {
	
	public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int n = nums.length, m = nums[0].length;
        if (r * c != n * m) return nums;
        int[][] res = new int[r][c];
        for (int i = 0; i < r * c; i++) {
        	res[i / c][i % c] = nums[i / m][i % m];
        }
        return res;
    }

	public static void main(String[] args) {
		int[][] t = {
				{1, 2},
				{3, 4}
		};
		for (int[] a : matrixReshape(t, 1, 4)){
			for (int s: a) {
				System.out.print(s + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		for (int[] a : matrixReshape(t, 2, 4)){
			for (int s: a) {
				System.out.print(s + " ");
			}
			System.out.println();
		}
		
	}

}

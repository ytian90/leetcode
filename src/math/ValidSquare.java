package math;
/**
 * 593. Valid Square
 * @author ytian
 *
 */
public class ValidSquare {
	
	/*
	 * 1. There are only two equal longest lenghts.
	 * 2. The non longest lengths are all equal.
	 */
	public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        long[] lengths = {len(p1, p2), len(p2, p3), len(p3, p4), len(p4, p1), len(p1, p3), len(p2, p4)};
        long max = 0, nonMax = 0;
        for (long len : lengths) {
        	max = Math.max(len, max);
        }
        int count = 0;
        for (int i = 0; i < lengths.length; i++) {
        	if (lengths[i] == max) count++;
        	else nonMax = lengths[i]; // non diagonal side
        }
        if (count != 2) return false; // diagnonals lengths have to be same
        for (long len : lengths) {
        	if (len != max && len != nonMax) return false; // sides have to be same length
        }
        return true;
    }

	private static long len(int[] p, int[] q) {
		return (long)Math.pow(p[0] - q[0], 2) + (long)Math.pow(p[1] - q[1], 2);
	}

	public static void main(String[] args) {
		System.out.println(validSquare(new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 0}, new int[]{0, 1}));
	}

}

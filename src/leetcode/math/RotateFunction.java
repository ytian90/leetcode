package leetcode.math;
/**
 * 396. Rotate Function
 * @author yutian
 *
 */
public class RotateFunction {
	
	public static int maxRotateFunction(int[] A) {
        if (A.length == 0) {
        	return 0;
        }
        int aset = 0, sum = 0, len = A.length;
        for (int i = 0; i < len; i++) {
        	aset += A[i];
        	sum += (A[i] * i);
        }
        int max = sum;
        for (int j = 1; j < len; j++) {
        	sum = sum - aset + A[j - 1] * len;
        	max = Math.max(max, sum);
        }
        return max;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = new int[]{4, 3, 2, 6};
		System.out.println(maxRotateFunction(test));
		
	}

}

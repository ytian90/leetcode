package math;
/**
 * 633. Sum of Square Numbers
 * @author ytian
 *
 */
public class SumofSquareNumbers {
	
	public static boolean judgeSquareSum(int c) {
        if (c < 0) {
        	return false;
        }
        int left = 0, right = (int) Math.sqrt(c);
        while (left <= right) {
        	int curr = left * left + right * right;
        	if (curr < c) {
        		left++;
        	} else if (curr > c) {
        		right--;
        	} else {
        		return true;
        	}
        }
        return false;
    }

	public static void main(String[] args) {
		System.out.println(judgeSquareSum(5));
		System.out.println(judgeSquareSum(3));
	}

}

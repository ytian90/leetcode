package math;
/**
 * Chocolate
 * http://www.1point3acres.com/bbs/thread-168216-1-1.html
 * @author yutian
 * @since Feb 6, 2016
 */
public class Chocolate {
	
	public static void getKth(int k) {
		int a = k / 2;
        int b = k - a;
        long result = 1L * a * b;
        System.out.println(result);
	}

	public static void main(String[] args) {
		getKth(5);
		getKth(6);
		getKth(7);
		getKth(8);
		
	}

}

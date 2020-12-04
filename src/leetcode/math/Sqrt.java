package leetcode.math;
/**
 * 69. Sqrt(x)
 * @author yutian
 * @since Aug 12, 2015
 */
public class Sqrt {
	// Time ~O(logN), Space ~O(1)
	public static int mySqrt(int x) {
		if (x < 0) throw new IllegalArgumentException();
        if (x < 2) return x;
        int lo = 1, hi = x;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int div = x / mid;
            if (div > mid) lo = mid + 1;
            else if (div < mid) hi = mid;
            else return mid;
        }
        return lo - 1;
	}
	
	public static int mySqrt2(int x) {
		if (x == 0)
			return 0;
		int lo = 1, hi = x;
		while (true) {
			int mid = lo + (hi - lo) / 2;
			if (mid > x / mid) {
				hi = mid - 1;
			} else {
				if (mid + 1 > x / (mid + 1)) {
					return mid;
				}
				lo = mid + 1;
			}
		}
	}
	
	// same as method 1, except (lo <= hi) and hi = mid - 1
	public static int mySqrt3(int x) {
		if (x == 0) return 0;
		int lo = 1, hi = x;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int div = x / mid;
			if (div > mid) lo = mid + 1;
            else if (div < mid) hi = mid - 1;
            else return mid;
		}
		return lo - 1;
	}
	
	public static void main(String[] args) {
		System.out.println(mySqrt(0));
		System.out.println(mySqrt(1));
		System.out.println(mySqrt(2)); // lo - 1
		System.out.println(mySqrt(3));
		System.out.println(mySqrt(4));
		System.out.println(mySqrt(10));
		System.out.println(mySqrt(256));
		System.out.println(mySqrt(1000));
//		System.out.println(mySqrt(-100));
	}
}

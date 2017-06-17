package dynamicProgramming;
/**
 * Ugly Number II
 * @author yutian
 * @since Aug 30, 2015
 */
public class UglyNumber2 {
	public static int nthUglyNumber(int n) {
		int[] ugly = new int[n];
		ugly[0] = 1;
		int i2 = 0, i3 = 0, i5 = 0;
		int f2 = 2, f3 = 3, f5 = 5;
		for (int i = 1; i < n; i++) {
			int min = Math.min(Math.min(f2, f3), f5);
			ugly[i] = min;
			if (f2 == min)
				f2 = 2 * ugly[++i2];
			if (f3 == min)
				f3 = 3 * ugly[++i3];
			if (f5 == min)
				f5 = 5 * ugly[++i5];
		}
		return ugly[n - 1];
	}
	
	public static void main(String[] args) {
		System.out.println(nthUglyNumber(10));
	}
}

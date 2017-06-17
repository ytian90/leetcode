package dynamicProgramming;
/**
 * 343. Integer Break
 * @author yutian
 * @since May 7, 2016
 */
public class IntegerBreak {
	
	public int integerBreak(int n) {
		if (n == 2) return 1;
        if (n == 3) return 2;
        if (n % 3 == 0) return (int) Math.pow(3, n / 3);
        else if (n % 3 == 1) return (int) Math.pow(3, n / 3 - 1) * 4;
        else return (int) Math.pow(3, n / 3) * 2;
    }

	public static void main(String[] args) {
		IntegerBreak t = new IntegerBreak();
		System.out.println(t.integerBreak(2));
		System.out.println(t.integerBreak(3));
		System.out.println(t.integerBreak(4));
		System.out.println(t.integerBreak(5));
		System.out.println(t.integerBreak(8));
		
	}

}

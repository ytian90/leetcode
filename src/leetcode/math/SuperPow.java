package leetcode.math;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * 372. Super Pow
 * @author yutian
 * @since Jul 17, 2016
 */
public class SuperPow {
	
	public static int superPow(int a, int[] b) {
        int[] pows = new int[1337];
        Set<Integer> set = new HashSet<>();
        int cycle = 0;
        int val = 1;
        for (int i = 0; i < 1337; i++) {
        	val = (int) (((long) val * a) % 1337);
        	if (set.contains(val)) break;
        	set.add(val);
        	pows[cycle++] = val;
        }
        StringBuilder sb = new StringBuilder();
        for(int v : b) sb.append(v);
        BigInteger bVal = new BigInteger(sb.toString());
        bVal = bVal.subtract(new BigInteger("1")).mod(new BigInteger("" + cycle));
        return pows[bVal.intValue()];
    }
	
	public static final int NUM = 1337;
	public static int superPow2(int a, int[] b) {
		int ans = 1;
		if (b == null || b.length == 0) {
			return 0;
		}
		a = a % NUM;
		int len = b.length;
		for (int i = 0; i < len; i++) {
			ans = ((pow(ans, 10) * pow(a, b[i])) % NUM);
		}
		return ans;
	}

	private static int pow(int a, int b) {
		if (b == 1) return a;
		if (b == 0) return 1;
		int x = pow(a, b / 2);
		x = (x * x) % NUM;
		if ((b & 1) == 1)
			x = (x * a) % NUM;
		return x;
		
	}

	public static void main(String[] args) {
		System.out.println(superPow(2, new int[]{3}));
		System.out.println(superPow(2, new int[]{1, 0}));
	}

}

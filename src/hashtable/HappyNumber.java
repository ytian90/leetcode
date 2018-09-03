package hashtable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 202. Happy Number
 * @author yutian
 * @since Aug 4, 2015
 */
public class HappyNumber {

	public static boolean isHappyy(int n) {
		Set<Integer> set = new HashSet<>();
		return helper(n, set);
	}

	private static boolean helper(int n, Set<Integer> set) {
		set.add(n);
		int sum = 0;
		while (n != 0) {
			int digit = n % 10;
			sum += digit * digit;
			n /= 10;
		}
		if (sum == 1) return true;
		if (set.contains(sum)) return false;
		return helper(sum, set);
	}
	
	// Solution 1 Set
	public static boolean isHappy(int n) {
		if (n <= 0) return false;
		if (n == 1) return true;
		int sum = 0;
		Set<Integer> set = new HashSet<>();
		while (n != 1 && set.add(n)) {
			sum = 0;
			while (n != 0) {
				sum += Math.pow(n % 10, 2);
				n /= 10;
			}
			if (sum == 1) return true;
			n = sum;
		}
		return false;
	}
	
	// Solution 2: ArrayList
	public static boolean isHappy2(int n) {
		if (n <= 0) return false;
        if (n == 1) return true;
        int sum = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (n != 1 && !list.contains(n)) {
            list.add(n);
            sum = 0;
            while (n != 0) {
                sum += Math.pow(n % 10, 2);
                n /= 10;
            }
            if (sum == 1) return true;
            n = sum;
        }
        return false;
	}
	
	public static void main(String[] args) {
//		 System.out.println(isHappy(19));
		System.out.println(isHappy(7));
	}
}

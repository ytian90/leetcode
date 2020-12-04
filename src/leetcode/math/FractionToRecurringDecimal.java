package leetcode.math;

import java.util.HashMap;
import java.util.Map;

/**
 * 166. Fraction to Recurring Decimal
 * @author yutian
 * @since Aug 13, 2015
 */
public class FractionToRecurringDecimal {
	// Solution 1
	public String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0) return "0";
		StringBuilder sb = new StringBuilder();
		// add sign + or -
		if (numerator < 0 ^ denominator < 0)
			sb.append("-");
		long n = Math.abs((long)numerator), d = Math.abs((long)denominator);
		// add integer part
		sb.append(n / d);
		// add digit or stop
		long r = n % d; // remainder, must long type
		if (r == 0)
			return sb.toString();
		else
			sb.append(".");
		// add fractional part
		// Hash Table stores <remainder, leetcode.string index>
		Map<Long, Integer> map = new HashMap<>();
		while (r > 0) {
			if (map.containsKey(r)) {
				sb.insert(map.get(r), "(");
				sb.append(")");
				break;
			} else {
				map.put(r, sb.length());
				r *= 10;
				sb.append(r / d);
				r %= d;
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		FractionToRecurringDecimal t = new FractionToRecurringDecimal();
		System.out.println(t.fractionToDecimal(-1, -2147483648));
	}
	
	// Solution 2
	public String fractionToDecimal2(int numerator, int denominator) {
		if (numerator == 0)
			return "0";
		if (denominator == 0)
			return "";
		String result = "";
		if (numerator < 0 ^ denominator < 0)
			result += "-";
		long num = numerator, den = denominator;
		num = Math.abs(num);
		den = Math.abs(den);
		long res = num / den;
		result += String.valueOf(res);
		long remainder = (num % den) * 10;
		if (remainder == 0)
			return result;
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		result += ".";
		while (remainder != 0) {
			if (map.containsKey(remainder)) {
				int beg = map.get(remainder);
				String part1 = result.substring(0, beg);
				String part2 = result.substring(beg);
				result = part1 + "(" + part2 + ")";
				return result;
			}
			map.put(remainder, result.length());
			res = remainder / den;
			result += String.valueOf(res);
			remainder = (remainder % den) * 10;
		}
		return result;
	}
}

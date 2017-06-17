package others;

/**
 * Decimal Zip
 * A = 12 B = 56 C = 1526
 * A = 56 B = 12 C = 5162
 * A = 12345 B = 678 C = 16273845
 * A = 1234 B = 0 C = 10234
 * @author yutian
 * @since Jan 22, 2016
 */
public class DecimalZip {
	
	public static int solution(int A, int B) {
		String a = Integer.toString(A);
		String b = Integer.toString(B);
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (i < Math.min(a.length(), b.length())) {
			sb.append(a.charAt(i));
			sb.append(b.charAt(i));
			i++;
		}
		while (i < a.length()) sb.append(a.charAt(i++));
		while (i < b.length()) sb.append(b.charAt(i++));
		int result = Integer.parseInt(sb.toString());
//		List<HashSet<Integer>> list = new ArrayList<HashSet<Integer>>();
		return result > 100000000 ? -1: result;
	}

	public static void main(String[] args) {
		System.out.println(solution(12, 56));
		System.out.println(solution(56, 12));
		System.out.println(solution(12345, 678));
		System.out.println(solution(1234, 0));
		System.out.println(solution(123, 67890));
	}

}

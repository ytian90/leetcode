package string;
/**
 * Count and Say
 * @author yutian
 * @since Aug 11, 2015
 */
public class CountAndSay {
	
	public static void main(String[] args) {
		System.out.println(countAndSay(3));
	}
	
	// Solution 1 better Time ~ O(N^2), Space ~ O(N) 
	public static String countAndSay(int n) {
		if (n <= 0) return null;
        StringBuilder sb = new StringBuilder("1");
        for (int i = 1; i < n; i++) {
            StringBuilder next = new StringBuilder();
            int count = 1;
            for (int j = 1; j < sb.length(); j++) { // it is sb.length()
                if (sb.charAt(j) == sb.charAt(j - 1)) {
                    count++;
                } else {
                    next.append(count);
                    next.append(sb.charAt(j - 1));
                    count = 1;
                }
            }
            next.append(count);
            next.append(sb.charAt(sb.length() - 1));
            sb = next;
        }
        return sb.toString();
	}
	
	// Solution 2
	public static String countAndSay2(int n) {
		if (n <= 0) return null;
		if (n == 1) return "1";
		String s = "1";
		for (int i = 1; i < n; i++) {
			String current = "";
			int j = 0, count = 1;
			while (j < s.length() - 1) {
				if (s.charAt(j + 1) == s.charAt(j)) {
					count++;
				} else {
					current += String.valueOf(count) + s.charAt(j);
					count = 1;
				}
				j++;
			}
			current += String.valueOf(count) + s.charAt(j);
			s = current;
		}
		return s;
	}
}

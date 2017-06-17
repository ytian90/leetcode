package string;

import java.util.ArrayList;
import java.util.List;

/**
 * 544. Output Contest Matches
 * @author ytian
 *
 */
public class OutputContestMatches {
	public static String findContestMatch1(int n) {
		String[] res = new String[n];
		for (int i = 1; i <= n; i++)
			res[i - 1] = "" + i;
		while (n > 1) {
			for (int i = 0; i < n / 2; i++) {
				res[i] = "(" + res[i] + "," + res[n - 1 - i] + ")";
			}
			n /= 2;
		}
		return res[0];
	}
	
	public static String findContestMatch(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
        	res.add(String.valueOf(i));
        }
        while (res.size() != 1) {
        	List<String> next = new ArrayList<>();
        	for (int i = 0; i < res.size() / 2; i++) {
        		next.add("(" + res.get(0) + "," + res.get(res.size() - 1 - i) + ")");
        	}
        	res = next;
        }
        return res.get(0);
    }
	
	public static void main(String[] args) {
		System.out.println(findContestMatch(2));
		System.out.println(findContestMatch1(4));
		System.out.println(findContestMatch(8));
	}

}

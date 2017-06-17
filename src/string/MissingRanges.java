package string;
import java.util.ArrayList;
import java.util.List;

/**
 * Missing Ranges
 * @author yutian
 * @since Jul 25, 2015
 */
public class MissingRanges {
	
	public static List<String> findMissingRanges(int[] vals, int start, int end) {
		List<String> ranges = new ArrayList<>();
		int prev = start - 1;
		for (int i = 0; i <= vals.length; i++) {
			int curr = (i == vals.length)? end + 1 : vals[i];
			if (curr - prev >= 2) {
				ranges.add(getRange(prev+1, curr-1));
			}
			prev = curr;
		}
		return ranges;
	}

	private static String getRange(int from, int to) {
		return (from == to)? String.valueOf(from) : from + "->" + to;
	}

	public static void main(String[] args) {
		int[] list = { 0, 1, 3, 50, 75 };
		int start = 0, end = 99;
		List<String> ans;
		ans = findMissingRanges(list, start, end);
		System.out.println(ans.toString());
	}

}

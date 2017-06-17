package array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Suffix Array
 * http://www.geeksforgeeks.org/Suffix-array-set-1-introduction/
 * @author yutian
 * @since Feb 4, 2016
 */
public class SuffixArray {
	
	public static int[] buildSuffixArray(String s, int n) {
		Suffix[] list = new Suffix[n];
		for (int i = 0; i < n; i++) {
			list[i] = new Suffix(i, s.substring(i));
		}
		Arrays.sort(list, new Comparator<Suffix>(){
			@Override
			public int compare(Suffix o1, Suffix o2) {
				return o1.suff.compareTo(o2.suff);
			}
		});
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			result[i] = list[i].index;
		}
		return result;
	}
	
	public static boolean search(String pat, String txt, int[] suffArr, int n) {
		int m = pat.length();
		int l = 0, r = n - 1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			// corner case: 4 na the length is 2, less than 3, may out of boundary
			String temp = txt.substring(suffArr[mid], 
					(suffArr[mid] + m > txt.length()) ? txt.length() : suffArr[mid] + m);
			int res = pat.compareTo(temp);
			if (res == 0) return true;
			if (res < 0) r = mid - 1;
			else l = mid + 1;
		}
		return false;
	}

	public static void main(String[] args) {
		String txt = "banana";
		int[] t1 = buildSuffixArray(txt, txt.length());
		for (int i: t1) System.out.print(i + " ");
		
		System.out.println(search("nan", txt, t1, txt.length()));
	}

}

package greedy;
/**
 * 484. Find Permutation
 * @author ytian
 *
 */
public class FindPermutation {
	
	public int[] findPermutation(String s) {
        int n = s.length(), res[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
        	res[i] = i + 1;
        }
        for (int h = 0; h < n; h++) {
        	if (s.charAt(h) == 'D') {
        		int l = h;
        		while (h < n && s.charAt(h) == 'D') h++;
        		reverse(res, l, h);
        	}
        }
        return res;
    }

	private void reverse(int[] res, int lo, int hi) {
		while (lo < hi) {
			int t = res[lo];
			res[lo] = res[hi];
			res[hi] = t;
			lo++; hi--;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

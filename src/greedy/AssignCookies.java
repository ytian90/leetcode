package greedy;

import java.util.Arrays;

/**
 * 455. Assign Cookies
 * @author ytian
 *
 */
public class AssignCookies {

    public static int findContentChildren(int[] g, int[] s) {
        int res = 0;
        if (g.length == 0 || s.length == 0) {
            return res;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int i = g.length - 1, j = s.length - 1;
        while (i >= 0 && j >= 0) {
            if (g[i] <= s[j]) {
                res++;
                i--; j--;
            } else {
                i--;
            }
        }
        return res;
    }


    public static int findContentChildren2(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        for (int j = 0; i < g.length && j < s.length; j++) {
        	if (g[i] <= s[j]) i++;
        }
        return i;
    }

	public static void main(String[] args) {
		System.out.println(findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
		System.out.println(findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));
	}

}

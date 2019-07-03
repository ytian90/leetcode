package backtracking;
/**
 * 526. Beautiful Arrangement
 * @author ytian
 *
 */
public class BeautifulArrangement {

	static int res = 0;

	public static int countArrangement(int N) {
		if (N == 1) return N;
		helper(N, 1, new boolean[N + 1]);
		return res;
	}

	public static void helper(int N, int pos, boolean[] visited) {
		if (pos == N + 1) {
			res++;
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (!visited[i] && (i % pos == 0 || pos % i == 0)) {
				visited[i] = true;
				helper(N, pos + 1, visited);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(countArrangement(2));
		System.out.println(countArrangement(3));
	}

	public static int countArrangement2(int N) {
        if (N == 0) return 0;
        helper(N, 1, new int[N + 1]);
        return res;
    }

	private static void helper(int N, int pos, int[] nums) {
		if (pos > N) {
			res++;
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (nums[i] == 0 && (i % pos == 0 || pos % i == 0)) {
				nums[i] = 1;
				helper(N, pos + 1, nums);
				nums[i] = 0;
			}
		}
	}

}

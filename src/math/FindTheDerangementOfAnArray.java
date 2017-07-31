package math;
/**
 * 634. Find the Derangement of An Array
 * @author ytian
 *
 */
public class FindTheDerangementOfAnArray {
	
	private static final int M = 1000000007;
	
	public static int findDerangement(int n) {
        long res = 1;
        for (int i = 1; i <= n; i++) {
        	res = (i * res % M + (i % 2 == 0 ? 1 : -1)) % M;
        }
        return (int) res;
    }

	public static void main(String[] args) {
		System.out.println(findDerangement(3));
	}

}

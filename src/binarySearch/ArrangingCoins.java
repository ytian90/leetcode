package binarySearch;
/**
 * 441. Arranging Coins
 * @author yutian
 *
 */
public class ArrangingCoins {
	
	public static int arrangeCoins(int n) {
        int start = 0, end = n, mid = 0;
        while (start <= end) {
        	mid = start + (end - start) / 2;
        	if ((0.5 * mid * mid + 0.5 * mid) <= n) {
        		start = mid + 1;
        	} else {
        		end = mid - 1;
        	}
        }
        return start - 1;
    }
	
	public static int arrangeCoins2(int n) {
        return (int) ((Math.sqrt(1 + 8.0 * n) - 1) / 2);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(arrangeCoins(5));
		System.out.println(arrangeCoins(8));
		System.out.println(arrangeCoins(22));
		
	}

}

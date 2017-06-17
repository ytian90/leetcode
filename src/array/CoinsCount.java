package array;
/**
 * Given 0 - 99 represent sum of cents from coins, how many coins do we need, output coin string
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=165632&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D2%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D5%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
 * @author yutian
 * @since Jan 14, 2016
 */
public class CoinsCount {
	
	public static final int[] coins = new int[]{1, 5, 10, 25};
	
	public static void coinChange(int amount) {
		int pen = 0, nic = 0, dim = 0, qua = 0;
		if (amount > coins[3]) {
			qua = amount / coins[3];
			amount -= qua * coins[3];
		}
		if (amount > coins[2]) {
			dim = amount / coins[2];
			amount -=  dim * coins[2];
		}
		if (amount > coins[1]) {
			nic = amount / coins[1];
			amount -= nic * coins[1];
		}
		if (amount > coins[0]) {
			pen = amount / coins[0];
			amount -= pen * coins[0];
		}
		System.out.println("quarter: " + qua + "\ndime: " + dim + "\nnickel: " + nic + "\npenny: " + pen);
	}

	public static void main(String[] args) {
		coinChange(77);
	}

}

package greedy;
/**
 * Gas Station
 * @author yutian
 * @since Aug 23, 2015
 */
public class GasStation {
	/**
	 * Every time when total gas - cost (incr to station i) < 0, we choose
	 * station i + 1 as start point.
	 * @param gas
	 * @param cost
	 * @return
	 */
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas.length == 1) {
			return gas[0] >= cost[0] ? 0 : -1;
		}
		int n = gas.length;
		for (int i = 0; i < n; i++) {
			int start = i, curr = i, currGas = gas[i], currCost = cost[i];
			while (currGas - currCost >= 0) {
				int next = (curr + 1) % n;
				if (next == start) {
					return start;
				}
				currGas = (currGas - currCost) + gas[next];
				currCost = cost[next];
				curr = next;
			}
		}
		return -1;
	}

	public static int canCompleteCircuit2(int[] gas, int[] cost) {
		int n = gas.length, currSum = 0, total = 0, res = 0;
		for (int i = 0; i < n; i++) {
			currSum += gas[i] - cost[i];
			if (currSum < 0) {
				total += currSum;
				currSum = 0;
				res = i + 1;
			}
		}
		total += currSum;
		return total < 0 ? -1 : res;
	}

	public static void main(String[] args) {
		System.out.println(canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
		System.out.println(canCompleteCircuit2(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
	}
}

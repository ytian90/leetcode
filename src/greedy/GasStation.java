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
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int prev = 0, total = 0, start = 0;
		for (int i = 0; i < gas.length; i++) {
			prev += gas[i] - cost[i];
			total += gas[i] - cost[i];
			if (prev < 0) {
				prev = 0;
				start = i + 1;
			}
		}
		return (total < 0) ? -1: start;
	}
}

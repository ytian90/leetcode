package array;

/**
 * 495. Teemo Attacking
 * 
 * @author ytian
 *
 */
public class TeemoAttacking {
	
	/**
	 * For each begin followed by t
		If t is within previous duration [begin, begin + duration] then increase total by t - begin
		If t in out of previous duration [begin, begin + duration] then increase total by duration
		In both cases update begin to the new begin time t
	 * @param timeSeries
	 * @param duration
	 * @return
	 */
	public static int findPoisonedDuration(int[] timeSeries, int duration) {
		if (timeSeries.length == 0)
			return 0;
		int begin = timeSeries[0], sum = 0;
		for (int t : timeSeries) {
			sum += t < begin + duration ? t - begin : duration;
			begin = t;
		}
		return sum + duration;
	}

	public static void main(String[] args) {
		System.out.println(findPoisonedDuration(new int[]{1, 4}, 2));
		System.out.println(findPoisonedDuration(new int[]{1, 2}, 2));
	}

}

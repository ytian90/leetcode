package string;
import java.util.HashMap;
import java.util.Map;

/**
 * Two Sum III - Data structure design
 * @author yutian
 * @since Jul 24, 2015
 */
public class TwoSum3 {
	
	private static Map<Integer, Integer> table = new HashMap<>();
	
	public static void add(int input) {
		int count = table.containsKey(input) ? table.get(input): 0;
		table.put(input, count + 1);
	}
	
	public static boolean find(int val) {
		for (Map.Entry<Integer, Integer> entry: table.entrySet()) {
			int num = entry.getKey();
			int y = val - num;
			if (y == num) {
				if (entry.getValue() >= 2) return true;
			} else if (table.containsKey(y)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		add(1);
		add(3);
		add(5);
		
		System.out.println(find(4));
		System.out.println(find(7));
		
	}

}

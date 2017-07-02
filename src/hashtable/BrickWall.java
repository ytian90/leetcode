package hashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 554. Brick Wall
 * @author ytian
 *
 */
public class BrickWall {
	
	public static int leastBricks(List<List<Integer>> wall) {
        if (wall.size() == 0) return 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> list : wall) {
        	int length = 0;
        	for (int i = 0; i < list.size() - 1; i++) {
        		length += list.get(i);
        		map.put(length, map.getOrDefault(length, 0) + 1);
        		count = Math.max(count, map.get(length));
        	}
        }
        return wall.size() - count;
    }
	
	public static void main(String[] args) {
		List<List<Integer>> t = 
				Arrays.asList(Arrays.asList(1, 2, 2, 1),
						      Arrays.asList(3, 1, 2),
						      Arrays.asList(1, 3, 2),
						      Arrays.asList(2, 4),
						      Arrays.asList(3, 1, 2),
						      Arrays.asList(1, 3, 1, 1));
		
		System.out.println(leastBricks(t));
		
	}

}

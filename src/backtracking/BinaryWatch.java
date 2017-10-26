package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 401. Binary Watch
 * @author yutian
 *
 */
public class BinaryWatch {

	public static List<String> readBinaryWatch(int num) {
        List<String> times = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
        	for (int m = 0; m < 60; m++) {
        		if ((Integer.bitCount(h) + Integer.bitCount(m)) == num) {
        			times.add(String.format("%d:%02d", h, m));
        		}
        	}
        }
        return times;
    }
	
	public static void main(String[] args) {
		System.out.println(readBinaryWatch(1));
	}

}

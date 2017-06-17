package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Moving Average
 * http://www.mitbbs.com/article_t/JobHunting/32625123.html
 * @author yutian
 * @since Jan 27, 2016
 */
public class MovingAverage {
	
	private static LinkedList<Double> list;
	private static int winSize;
	private static Double sum;
	
	public MovingAverage(int size) {
		list = new LinkedList<>();
		winSize = size;
		sum = 0.0;
	}
	
	public static Double next(Double input) {
		if (list.size() < winSize) {
			sum += input;
			list.add(input);
			return sum / list.size();
		} else {
			Double output = list.remove();
			list.add(input);
			sum = sum - output + input;
			return sum / winSize;
		}
	}

	public static void main(String[] args) {
		MovingAverage t = new MovingAverage(2);
		System.out.println(t.next(1.0));
		System.out.println(t.next(2.0));
		System.out.println(t.next(3.0));
		System.out.println(t.next(4.0));
		
	}

}

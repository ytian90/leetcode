package array;

import java.util.Arrays;

/**
 * 492. Construct the Rectangle
 * @author ytian
 *
 */
public class ConstructTheRectangle {
	
	public static int[] constructRectangle(int area) {
        int w = (int) Math.sqrt(area);
        while (area % w != 0) w--;
        return new int[]{area / w, w};
    }

	public static void main(String[] args) {
		System.out.println(Arrays.toString(constructRectangle(4)));
		System.out.println(Arrays.toString(constructRectangle(5)));
		System.out.println(Arrays.toString(constructRectangle(6)));
	}

}

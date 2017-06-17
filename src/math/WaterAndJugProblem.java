package math;
/**
 * 365. Water and Jug Problem
 * @author yutian
 * @since Jul 3, 2016
 */
public class WaterAndJugProblem {
	
	public static boolean canMeasureWater(int x, int y, int z) {
        if (z == x + y || z == x || z == y || z == 0) {
        	return true;
        }
        if (x == 0 || y == 0 || z > x + y || z % gcd(x, y) != 0) {
        	return false;
        }
        return true;
    }
	
	private static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	public static void main(String[] args) {
		System.out.println(canMeasureWater(3, 5, 4));
		System.out.println(canMeasureWater(2, 6, 5));
		System.out.println(canMeasureWater(1, 1, 12));

	}

}

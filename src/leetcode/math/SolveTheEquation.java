package leetcode.math;
/**
 * 640. Solve the Equation
 * @author ytian
 *
 */
public class SolveTheEquation {
	
	public static String solveEquation(String equation) {
        int[] left = helper(equation.split("=")[0]),
        	  right = helper(equation.split("=")[1]);
        left[0] -= right[0];
        left[1] = right[1] - left[1];
        if (left[0] == 0 && left[1] == 0) return "Infinite solutions";
        if (left[0] == 0) return "No solution";
        return "x=" + left[1] / left[0];
    }

	private static int[] helper(String s) {
		String[] tokens = s.split("(?=[-+])");
		int[] res = new int[2];
		for (String t: tokens) {
			if (t.equals("+x") || t.equals("x")) res[0]++;
			else if (t.equalsIgnoreCase("-x")) res[0]--;
			else if (t.contains("x")) res[0] += Integer.parseInt(t.substring(0, t.indexOf("x")));
			else res[1] += Integer.parseInt(t);
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(solveEquation("x+5-3+x=6+x-2"));
		System.out.println(solveEquation("x=x"));
		System.out.println(solveEquation("2x=x"));
		System.out.println(solveEquation("2x+3x-6x=x+2"));
		System.out.println(solveEquation("x=x+2"));
	}

}

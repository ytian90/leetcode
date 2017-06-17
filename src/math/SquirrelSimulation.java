package math;
/**
 * 573. Squirrel Simulation
 * @author ytian
 *
 */
public class SquirrelSimulation {
	
	public static int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int sum = 0, max = Integer.MIN_VALUE;
        for (int[] n : nuts) {
        	int distance = Math.abs(tree[0] - n[0]) + Math.abs(tree[1] - n[1]);
        	sum += 2 * distance;
        	max = Math.max(max, distance - Math.abs(squirrel[0] - n[0]) - Math.abs(squirrel[1] - n[1]));
        }
        return sum - max;
    }
	
	public static int minDistance2(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
		int n = nuts.length;
		int[] nutToTree = new int[n];
		int[] nutToSquirrel = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			nutToTree[i] = Math.abs(nuts[i][0] - tree[0]) + Math.abs(nuts[i][1] - tree[1]);
			sum += 2 * nutToTree[i];
			nutToSquirrel[i] = Math.abs(nuts[i][0] - squirrel[0]) + Math.abs(nuts[i][1] - squirrel[1]);
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int distance = sum + nutToSquirrel[i] - nutToTree[i];
			min = Math.min(min, distance);
		}
		return min;
	}

	public static void main(String[] args) {
		System.out.println(minDistance(5, 7, new int[]{2, 2}, new int[]{4, 4}, new int[][]{{3,0}, {2, 5}}));
	}
	
}

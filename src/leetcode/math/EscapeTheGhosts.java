package leetcode.math;

/**
 * 789. Escape The Ghosts
 */
public class EscapeTheGhosts {
    public static boolean escapeGhosts(int[][] ghosts, int[] target) {
        int max = Math.abs(target[0]) + Math.abs(target[1]);
        for (int[] ghost : ghosts) {
            int d = Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]);
            if (d <= max) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(escapeGhosts(new int[][]{
                {1, 0},
                {0, 3}
        }, new int[]{0, 1}));

        System.out.println(escapeGhosts(new int[][]{
                {1, 0}
        }, new int[]{2, 0}));

        System.out.println(escapeGhosts(new int[][]{
                {2, 0}
        }, new int[]{1, 0}));
    }
}

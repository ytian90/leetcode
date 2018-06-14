package string;

/**
 * 657. Judge Route Circle
 */
public class JudgeRouteCircle {
    public static boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'R') x++;
            if (c == 'L') x--;
            if (c == 'U') y++;
            if (c == 'D') y--;
        }
        return x == 0 && y == 0;
    }

    public static void main(String[] args) {
        System.out.println(judgeCircle("UD"));
        System.out.println(judgeCircle("LL"));
        System.out.println(judgeCircle("RLUURDDDLU"));
        System.out.println(judgeCircle("RDDDDDLURD"));
    }
}

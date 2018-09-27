package math;

/**
 * 858. Mirror Reflection
 */
public class MirrorReflection {

    /**
     * Divide p,q by 2 until at least one odd.
     *
     * If p = odd, q = even: return 0
     * If p = even, q = odd: return 2
     * If p = odd, q = odd: return 1
     * I summary it as return 1 - p % 2 + q % 2
     *
     * @param p
     * @param q
     * @return
     */
    public static int mirrorReflection(int p, int q) {
        while (p % 2 == 0 && q % 2 == 0) {
            p >>= 1;
            q >>= 1;
        }
        return 1 - p % 2 + q % 2;
    }

    public static void main(String[] args) {
        System.out.println(mirrorReflection(2, 1));
        System.out.println(mirrorReflection(1, 1));
        System.out.println(mirrorReflection(1, 2));
    }
}

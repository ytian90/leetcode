package leetcode.math;

/**
 * 858. Mirror Reflection
 */
public class MirrorReflection {

    /**
     So, this problem can be transformed into finding m * p = n * q, where
     m = the number of room extension + 1.
     n = the number of light reflection + 1.

     If the number of light reflection is odd (which means n is even), it means the corner is on the left-hand side. The possible corner is 2.
     Otherwise, the corner is on the right-hand side. The possible corners are 0 and 1.
     Given the corner is on the right-hand side.
     If the number of room extension is even (which means m is odd), it means the corner is 1. Otherwise, the corner is 0.
     */
    public static int mirrorReflection(int p, int q) {
        int m = 1, n = 1;
        while(m * p != n * q){
            n++;
            m = n * q / p;
        }
        if (m % 2 == 0 && n % 2 == 1) return 0;
        if (m % 2 == 1 && n % 2 == 1) return 1;
        if (m % 2 == 1 && n % 2 == 0) return 2;
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(mirrorReflection(2, 1));
        System.out.println(mirrorReflection(1, 1));
        System.out.println(mirrorReflection(1, 2));
    }
}

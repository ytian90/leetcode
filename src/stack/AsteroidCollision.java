package stack;

import java.util.Stack;

/**
 * 735. Asteroid Collision
 */
public class AsteroidCollision {

    public static int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length == 0)
            return new int[]{};
        if (asteroids.length < 2)
            return asteroids;
        Stack<Integer> stack = new Stack<>();
        for (int c : asteroids) {
            if (c > 0) {
                stack.push(c);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && -c > stack.peek()) {
                    stack.pop();
                }
                if (stack.isEmpty() || stack.peek() < 0)
                    stack.push(c);
                else if (stack.peek() == -c)
                    stack.pop();
            }
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        System.out.println(asteroidCollision(new int[]{5, 10, -5}));
        System.out.println(asteroidCollision(new int[]{9, -9}));
        System.out.println(asteroidCollision(new int[]{10, 2, -5}));
        System.out.println(asteroidCollision(new int[]{-2, -1, 1, 2}));
    }
}

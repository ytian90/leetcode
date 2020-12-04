package leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 735. Asteroid Collision
 */
public class AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length == 0) {
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else {
                if (stack.isEmpty()) {
                    stack.push(asteroids[i]);
                } else {
                    while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroids[i])) {
                        stack.pop();
                    }
                    if (stack.isEmpty() || stack.peek() < 0) {
                        stack.push(asteroids[i]);
                        continue;
                    } else if (stack.peek() == Math.abs(asteroids[i])) {
                        stack.pop();
                    }
                }
            }
        }
        int size = stack.size();
        int[] res = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(asteroidCollision(new int[]{5, 10, -5})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{5, -5})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{10, 2, -5})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{-2, -1, 1, 2})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{-2, -2, 1, -2})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{1, -2, -2, -2})));
    }

    public static int[] asteroidCollision2(int[] asteroids) {
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
}

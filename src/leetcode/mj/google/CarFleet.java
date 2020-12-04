package leetcode.mj.google;

import java.util.Arrays;

/**
 * 10. Car Fleet
 */
public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        int len = position.length;
        Car[] cars = new Car[len];
        for (int i = 0; i < len; i++) {
            cars[i] = new Car(position[i], speed[i], target);
        }
        Arrays.sort(cars, (a, b) -> (a.pos - b.pos));
        int carFleet = len;
        for (int i = len - 1; i > 0; i--) {
            if (cars[i].time >= cars[i - 1].time) {
                cars[i - 1].time = cars[i].time;
                carFleet--;
            }
        }
        return carFleet;
    }

    private static class Car{
        int pos;
        int speed;
        double time;
        public Car(int pos, int speed, int target) {
            this.pos = pos;
            this.speed = speed;
            this.time = (target - pos + 0.0) / speed;
        }
    }
}

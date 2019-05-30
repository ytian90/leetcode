package mj.houzz;

import java.util.LinkedList;
import java.util.Queue;

/**
 * add/delete node 的优化， 用circular array, head 和 tail 指针指向queue的头尾
 * follow up: data size is big, store in database
 */
public class MovingAverage {

    Queue<Integer> q;
    int size;
    long sum;

    public MovingAverage(int size) {
        this.size = size;
        sum = 0;
        q = new LinkedList<>();
    }

    public double next(int val) {
        q.add(val);
        if (q.size() <= size) {
            sum += val;
        } else {
            sum = sum - q.poll() + val;
        }
        return (double) sum / q.size();
    }
}

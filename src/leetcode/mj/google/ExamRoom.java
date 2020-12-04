package leetcode.mj.google;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * lc855 exam room students sit separately
 */
public class ExamRoom {
    // Method 1: PriorityQueue seat O(logn) leave O(n)
    PriorityQueue<Interval> pq;
    int N;

    public class Interval {
        int x, y, dist;
        public Interval(int x, int y) {
            this.x = x;
            this.y = y;
            if (x == -1) {
                this.dist = y;
            } else if (y == N) {
                this.dist = N - 1 - x;
            } else {
                this.dist = Math.abs(x - y) / 2;
            }
        }
    }

    public ExamRoom(int N) {
        this.pq = new PriorityQueue<>((a, b) -> (a.dist != b.dist) ? b.dist - a.dist : a.x - b.x);
        this.N = N;
        pq.add(new Interval(-1, N));
    }

    public int seat() {
        int seat = 0;
        Interval curr = pq.poll();
        if (curr.x == -1) {
            seat = 0;
        } else if (curr.y == N) {
            seat = N - 1;
        } else {
            seat = curr.x + (curr.y - curr.x) / 2;
        }
        pq.add(new Interval(curr.x, seat));
        pq.add(new Interval(seat, curr.y));
        return seat;
    }

    public void leave(int p) {
        Interval head = null, tail = null;
        List<Interval> list = new ArrayList<>(pq);
        for (Interval i : list) {
            if (p == i.x) tail = i;
            if (p == i.y) head = i;
            if (head != null && tail != null) {
                break;
            }
        }
        pq.remove(head);
        pq.remove(tail);
        pq.offer(new Interval(head.x, tail.y));
    }

    // Method 2: treeSet seat O(n) leave O(logn)
    TreeSet<Integer> set;
//    int N; // comment out since duplicated as above

    public ExamRoom(int N, int addedForNothing_NotUsed) {
        set = new TreeSet<>();
        this.N = N;
    }

    public int seat2() {
        if (set.size() == 0) {
            set.add(0);
            return 0;
        }
        int gap = set.first(), seat = 0, prev = set.first();
        for (int curr : set) {
            if ((curr - prev) / 2 > gap) {
                gap = (curr - prev) / 2;
                seat = prev + gap;
            }
            prev = curr;
        }
        if (N - 1 - prev > gap) {
            seat = N - 1;
        }
        set.add(seat);
        return seat;
    }

    public void leave2(int p) {
        set.remove(p);
    }
}

package leetcode.design;

import java.util.*;

public class DesignALeaderboard {
    Map<Integer, Integer> map;
    PriorityQueue<Integer> scores;

    public DesignALeaderboard() {
        this.map = new HashMap<>();
        this.scores = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addScore(int playerId, int score) {
        if (map.containsKey(playerId)) {
            int originalValue = map.get(playerId);
            scores.remove(originalValue);
            scores.add(originalValue + score);
            map.put(playerId, originalValue + score);
        } else {
            scores.add(score);
            map.put(playerId, score);
        }
    }

    public int top(int K) {
        List<Integer> temp = new ArrayList<>();
        int sum = 0;
        while (K > 0) {
            int score = scores.poll();
            sum += score;
            temp.add(score);
            K--;
        }
        scores.addAll(temp);
        return sum;
    }

    public void reset(int playerId) {
        scores.remove(map.get(playerId));
        map.remove(playerId);
    }

    public static void main(String[] args) {
        DesignALeaderboard b = new DesignALeaderboard();
        b.addScore(1, 13);
        b.addScore(2, 93);
        b.addScore(3, 84);
        b.addScore(4, 6);
        b.addScore(5, 89);
        b.addScore(6, 31);
        b.addScore(7, 7);
        b.addScore(8, 1);
        b.addScore(9, 98);
        b.addScore(10, 42);
        System.out.println(b.top(5));
        b.reset(1);
        b.reset(2);
        b.addScore(3, 76);
        b.addScore(4, 68);
        System.out.println(b.top(1));
    }
}

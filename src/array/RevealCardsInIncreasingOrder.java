package array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 950. Reveal Cards In Increasing Order
 */
public class RevealCardsInIncreasingOrder {

    public static int[] deckRevealedIncreasing(int[] deck) {
        if (deck == null || deck.length == 0)
            return new int[]{};
        int n = deck.length;
        int[] res = new int[n];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) q.add(i);
        Arrays.sort(deck);
        for (int i = 0; i < n; i++) {
            res[q.poll()] = deck[i];
            q.offer(q.poll());
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(deckRevealedIncreasing
                (new int[]{17,13,11,2,3,5,7})));
    }
}

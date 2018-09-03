package binaryTree;

/**
 * 683. K Empty Slots
 */
public class KEmptySlots {

    public static int kEmptySlots(int[] flowers, int k) {
        int[] days = new int[flowers.length];
        for (int i = 0; i < flowers.length; i++) {
            days[flowers[i] - 1] = i + 1;
        }
        int left = 0, right = k + 1, res = Integer.MAX_VALUE;
        for (int i = 0; right < days.length; i++) {
            if (days[i] < days[left] || days[i] <= days[right]) {
                if (i == right)
                    res = Math.min(res, Math.max(days[left], days[right]));
                left = i;
                right = k + 1 + i;
            }
        }
        return (res == Integer.MAX_VALUE) ? -1: res;
    }

    public static void main(String[] args) {
        System.out.println(kEmptySlots(new int[]{1, 2, 3}, 1));
        System.out.println(kEmptySlots(new int[]{1, 3, 2}, 1));
    }
}

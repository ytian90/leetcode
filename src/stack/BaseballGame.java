package stack;

import java.util.LinkedList;

/**
 * 682. Baseball Game
 */
public class BaseballGame {
    public static int calPoints(String[] ops) {
        if (ops == null || ops.length == 0)
            return 0;
        int sum = 0;
        LinkedList<Integer> l = new LinkedList<>();
        for (String s : ops) {
            if (s.equals("+")) {
                l.add(l.peekLast() + l.get(l.size() - 2));
                sum += l.peekLast();
            } else if (s.equals("D")) {
                l.add(l.peekLast() * 2);
                sum += l.peekLast();
            } else if (s.equals("C")) {
                sum -= l.removeLast();
            } else {
                l.add(Integer.parseInt(s));
                sum += l.peekLast();
            }

        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"5","2","C","D","+"}));
        System.out.println(calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
    }
}

package mj.linkedin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Generic class permutation
 */
public class GenericClassPermutation {

    static class Permutation<T extends Comparable<T>> {
        public List<List<T>> permutation(T[] input) {
            List<List<T>> res = new ArrayList<>();
            if (input.length == 0 || input == null)
                return res;
            Arrays.sort(input, new Comparator<T>() {
                @Override
                public int compare(T o1, T o2) {
                    if (o1.compareTo(o2) > 0)
                        return 1;
                    else if (o1.compareTo(o2) < 0)
                        return -1;
                    else
                        return 0;
                }
            });
            findPermutation(res, new ArrayList<>(), input, new boolean[input.length]);
            return res;
        }

        private void findPermutation(List<List<T>> res, ArrayList<T> to_add, T[] input, boolean[] visited) {
            if (to_add.size() == input.length)
                res.add(new ArrayList<>(to_add));
            else {
                for (int i = 0; i < input.length; i++) {
                    if (visited[i] || (i != 0 && input[i] == input[i - 1] && visited[i - 1])) continue;
                    visited[i] = true;
                    to_add.add(input[i]);
                    findPermutation(res, to_add, input, visited);
                    to_add.remove(to_add.size() - 1);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Permutation<Integer> obj = new Permutation<>();
        System.out.println(obj.permutation(new Integer[]{1, 2, 3}));
        Permutation<String> obj2 = new Permutation<>();
        System.out.println(obj2.permutation(new String[]{"a", "b", "c"}));
        Permutation<Character> obj3 = new Permutation<>();
        System.out.println(obj3.permutation(new Character[]{'x', 'y', 'z'}));
    }
}

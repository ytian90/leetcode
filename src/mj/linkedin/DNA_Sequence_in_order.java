package mj.linkedin;

import java.util.*;
import java.util.stream.Collectors;

/**
 * data stream is character, may contain all characters
 // output as in order and in O(n)
 // A -> 0
 // C -> 1
 // G -> 2
 // T -> 3
 */
public class DNA_Sequence_in_order {

    public static List<String> findDNA(Iterator<Character> input) {
        Map<Long, String> sequence = new HashMap<>();
        int[] number = new int[26];
        number[0] = 0;
        number['C' - 'A'] = 1;
        number['G' - 'A'] = 2;
        number['T' - 'A'] = 3;

        StringBuilder buffer = new StringBuilder();
        Set<String> seen = new HashSet<>();
        long maxIndex = 0;
        int count = 10;
        while (count > 0 && input.hasNext()) {
            buffer.append(input.next());
            count--;
        }
        if (buffer.length() < 10) {
            return new ArrayList<>();
        }
        seen.add(buffer.toString());
        while (input.hasNext()) {
            buffer.delete(0, 1);
            buffer.append(input.next());
            if (seen.contains(buffer.toString())) {
                long index = getIndex(buffer.toString(), number);
                maxIndex = Math.max(maxIndex, index);
                sequence.put(index, buffer.toString());
            } else {
                seen.add(buffer.toString());
            }
        }

        List<String> res = new ArrayList<>();
        for (long i = 0; i <= maxIndex; i++) {
            if (sequence.containsKey(i)) {
                res.add(sequence.get(i));
            }
        }
        return res;
    }

    private static long getIndex(String dna, int[] number) {
        long index = 0;
        for (Character c : dna.toCharArray()) {
            index = index * 10 + number[c - 'A'];
        }
        return index;
    }

    public static void main(String[] args) {
        ArrayList<Character> dnas = new ArrayList<>();
        dnas.addAll("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT".chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
        Iterator it = dnas.iterator();
        System.out.println(findDNA(it));
    }
}

package company.uuba.mj;

/**
 * LC 1286. Iterator for Combination
 * Design the CombinationIterator class:
 *
 * CombinationIterator(string characters, int combinationLength) Initializes the object with a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
 * next() Returns the next combination of length combinationLength in lexicographical order.
 * hasNext() Returns true if and only if there exists a next combination.
 *
 * Example 1:
 *
 * Input
 * ["CombinationIterator", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
 * [["abc", 2], [], [], [], [], [], []]
 * Output
 * [null, "ab", true, "ac", true, "bc", false]
 *
 * Explanation
 * CombinationIterator itr = new CombinationIterator("abc", 2);
 * itr.next();    // return "ab"
 * itr.hasNext(); // return True
 * itr.next();    // return "ac"
 * itr.hasNext(); // return True
 * itr.next();    // return "bc"
 * itr.hasNext(); // return False
 */
public class IteratorForCombination {
    int bitmask, n, k;
    String chars;

    public IteratorForCombination(String characters, int combinationLength) {
        this.n = characters.length();
        this.k = combinationLength;
        this.chars = characters;
        this.bitmask = (1 << n) - (1 << (n - k));
    }

    public String next() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if ((bitmask & (1 << n - 1 - i)) != 0) {
                sb.append(chars.charAt(i));
            }
        }
        bitmask--;
        while (bitmask > 0 && Integer.bitCount(bitmask) != k) {
            bitmask--;
        }
        return sb.toString();
    }

    public boolean hasNext() {
        return bitmask > 0;
    }

    public static void main(String[] args) {
        IteratorForCombination itr = new IteratorForCombination("abc", 2);
        itr.next();    // return "ab"
        itr.hasNext(); // return True
        itr.next();    // return "ac"
        itr.hasNext(); // return True
        itr.next();    // return "bc"
        itr.hasNext(); // return False
    }
}

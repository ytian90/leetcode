package leetcode.backtracking;

// LC 1286. Iterator for Combination
public class IteratorForCombination {
//    int bitmask, n, k;
//    String chars;
//
//    public IteratorForCombination(String characters, int combinationLength) {
//        n = characters.length();
//        k = combinationLength;
//        chars = characters;
//        bitmask = (1 << n) - (1 << n - k);
//    }
//
//    public String next() {
//        StringBuilder curr = new StringBuilder();
//        for (int j = 0; j < n; j++) {
//            if ((bitmask & (1 << n - j - 1)) != 0) {
//                curr.append(chars.charAt(j));
//            }
//        }
//        bitmask--;
//        while (bitmask > 0 && Integer.bitCount(bitmask) != k) {
//            bitmask--;
//        }
//        return curr.toString();
//    }
//
//    public boolean hasNext() {
//        return bitmask > 0;
//    }

    int[] nums;
    boolean has_next;
    int n, k;
    String chars;

    public IteratorForCombination(String characters, int combinationLength) {
        n = characters.length();
        k = combinationLength;
        chars = characters;

        // init the first combination
        has_next = true;
        nums = new int[k];
        for (int i = 0; i < k; ++i) {
            nums[i] = i;
        }
    }

    public String next() {
        StringBuilder curr = new StringBuilder();
        for (int j: nums) {
            curr.append(chars.charAt(j));
        }

        // Generate next combination.
        // Find the first j such that nums[j] != n - k + j.
        // Increase nums[j] by one.
        int j = k - 1;
        while (j >= 0 && nums[j] == n - k + j) {
            j--;
        }

        if (j >= 0) {
            nums[j]++;
            for (int i = j + 1; i < k; i++) {
                nums[i] = nums[j] + i - j;
            }
        } else {
            has_next = false;
        }

        return curr.toString();
    }

    public boolean hasNext() {
        return has_next;
    }

    public static void main(String[] args) {
        IteratorForCombination iterator = new IteratorForCombination("abcdefg", 3);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

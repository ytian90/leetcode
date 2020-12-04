package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 422. Valid Word Square
 */
public class ValidWordSquare {

    public static boolean validWordSquare(List<String> words) {
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.get(i).length(); j++) {
                try {
                    if (words.get(i).charAt(j) != words.get(j).charAt(i)) {
                        return false;
                    }
                } catch (IndexOutOfBoundsException e) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean validWordSquaree(List<String> words) {
        if (words == null || words.size() == 0) {
            return true;
        }
        int n = words.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < words.get(i).length(); j++) {
                if (j >= n || words.get(j).length() <= i || words.get(j).charAt(i) != words.get(i).charAt(j))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validWordSquare(new ArrayList<>(Arrays.asList("abcd", "bnrt", "crmy", "dtye"))));
        System.out.println(validWordSquare(new ArrayList<>(Arrays.asList("abcd", "bnrt", "crm", "dt"))));
        System.out.println(validWordSquare(new ArrayList<>(Arrays.asList("ball", "area", "read", "lady"))));
    }
}

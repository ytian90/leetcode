package leetcode.string;

/**
 * 408. Valid Word Abbreviation
 */
public class ValidWordAbbreviation {

    public static boolean validWordAbbreviation(String word, String abbr) {
        return word.matches(abbr.replaceAll("[1-9]\\d*", ".{$0}"));
    }

    public static void main(String[] args) {
        System.out.println(validWordAbbreviation("internationalization", "i12iz4n"));
        System.out.println(validWordAbbreviation("apple", "a2e"));
    }
}

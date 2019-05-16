package mj.airbnb;

/**
 * 13. Regular Expression
 */
public class RegularExpression {

    public boolean regMatch(String source, String pattern) {
        if (pattern.length() == 0)
            return source.length() == 0;
        if (pattern.length() == 1) {
            if (source.length() != 1) return false;
            return source.charAt(0) == pattern.charAt(0);
        }

        if (source.length() != 0 && (pattern.charAt(0) == '.' || pattern.charAt(0) == source.charAt(0))) {
            if (pattern.charAt(1) == '*') {
                return regMatch(source.substring(1), pattern) || regMatch(source, pattern.substring(2));
            } else if (pattern.charAt(1) == '+') {
                return regMatch(source.substring(1), pattern.substring(2)) || regMatch(source.substring(1), pattern.substring(2));
            } else {
                return regMatch(source.substring(1), pattern.substring(1));
            }
        }
        return pattern.charAt(1) == '*' && regMatch(source, pattern.substring(2));
    }
}

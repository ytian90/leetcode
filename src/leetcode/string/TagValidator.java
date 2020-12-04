package leetcode.string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 591. Tag Validator
 * @author ytian
 *
 */
public class TagValidator {
	
	public static boolean isValid(String code) {
        Deque<String> s = new ArrayDeque<>();
        for (int i = 0; i < code.length(); ) {
        	if (i > 0 && s.isEmpty()) return false;
        	if (code.startsWith("<![CDATA[", i)) {
        		int j = i + 9;
        		i = code.indexOf("]]>", j);
        		if (i < 0) return false;
        		i += 3;
        	} else if (code.startsWith("</", i)) {
            	int j = i + 2;
            	i = code.indexOf('>', j);
            	if (i < 0 || i == j || i - j > 9) return false;
            	for (int k = j; k < i; k++) {
            		if (!Character.isUpperCase(code.charAt(k))) return false;
            	}
            	String str = code.substring(j, i++);
            	if (s.isEmpty() || !s.pop().equals(str)) return false;
            } else if (code.startsWith("<", i)) {
            	int j = i + 1;
            	i = code.indexOf('>', j);
            	if (i < 0 || i == j || i - j > 9) return false;
            	for (int k = j; k < i; k++) {
            		if (!Character.isUpperCase(code.charAt(k))) return false;
            	}
            	String str = code.substring(j, i++);
            	s.push(str);
            } else {
            	i++;
            }
        }
        return s.isEmpty();
    }

	public static void main(String[] args) {
		System.out.println(isValid("<DIV>This is the first line <![CDATA[<div>]]></DIV>"));
		System.out.println(isValid("<DIV>>>  ![cdata[]] <![CDATA[<div>]>]]>]]>>]</DIV>"));
		System.out.println(isValid("<A>  <B> </A>   </B>"));
		System.out.println(isValid("<DIV>  div tag is not closed  <DIV>"));
		System.out.println(isValid("<DIV>  unmatched <  </DIV>"));
		System.out.println(isValid("<DIV> closed tags with invalid tag name  <b>123</b> </DIV>"));
		System.out.println(isValid("<DIV> unmatched tags with invalid tag name  </1234567890> and <CDATA[[]]>  </DIV>"));
		System.out.println(isValid("<DIV>  unmatched start tag <B>  and unmatched end tag </C>  </DIV>"));
	}

}

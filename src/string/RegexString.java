package string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * 
 * @author ytian
 *
 */
public class RegexString {
	
	// Complete a auto-complete feature
	// dict = ["HelloWorld", "Hello", "WorldIsRound"]
	// H, He -> ["HelloWorld", "Hello"]
	// HW, HelW, HelWo -> ["HelloWorld"]
	// WI, WoIs, WIRound -> ["WorldIsRound"]
	public static List<String> autoComplete(Set<String> dict, String s) {
		System.out.println(Pattern.matches("H*", "HelloWorld"));
		System.out.println(Pattern.matches("H*", "Hello"));
		System.out.println(Pattern.matches("He", "Hello"));
		System.out.println(Pattern.matches("He", "HelloWorld"));
		
		
		
		return null;
	}
	
	public static void main(String[] args) {
		Set<String> dict = new HashSet<>(Arrays.asList("HelloWorld", "Hello", "WorldIsRound"));
		System.out.println(autoComplete(dict, "H"));
	}

}

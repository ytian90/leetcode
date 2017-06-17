package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Find Unique Prefixes
 * Square Interview Questions
 * inputs 		outputs
 * simple		sim
 * single 		sin
 * solution		so
 * a			a
 * @author yutian
 * @since Jan 26, 2016
 */
public class FindUniquePrefixes {

	public static void main(String[] args) {
		Trie t = new Trie();
		t.insert("zebra");
		t.insert("dog");
		t.insert("duck");
		t.insert("dove");
		t.insert("simple");
		t.insert("single");
		t.insert("solution");
		t.insert("a");
		
		System.out.println(t.getPrefix("zebra"));
		System.out.println(t.getPrefix("dog"));
		System.out.println(t.getPrefix("duck"));
		System.out.println(t.getPrefix("dove"));
		System.out.println(t.getPrefix("simple"));
		System.out.println(t.getPrefix("single"));
		System.out.println(t.getPrefix("solution"));
		System.out.println(t.getPrefix("a"));
	}

}

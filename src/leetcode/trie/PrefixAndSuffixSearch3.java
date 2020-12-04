package leetcode.trie;

/**
 * 745. Prefix and Suffix Search (Method 3)
 * If the input leetcode.string leetcode.array might change frequently
 * @author ytian
 *
 */
public class PrefixAndSuffixSearch3 {
	String[] input;
	
	public PrefixAndSuffixSearch3(String[] words) {
		input = words;
    }
    
    public int f(String prefix, String suffix) {
    		for (int i = input.length - 1; i >= 0; i--) {
    			if (input[i].startsWith(prefix) && input[i].endsWith(suffix))
    				return i;
    		}
    		return -1;
    }

	public static void main(String[] args) {
		String[] words = new String[] {"apple"};
		PrefixAndSuffixSearch3 obj = new PrefixAndSuffixSearch3(words);
		System.out.println(obj.f("a", "e"));
		System.out.println(obj.f("b", ""));
	}

}

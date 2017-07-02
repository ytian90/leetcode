package hashTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Repeated DNA Sequences
 * @author yutian
 * @since Aug 24, 2015
 */
public class RepeatedDNASequences {
	
	public static List<String> findRepeatedDnaSequences(String s) {
		Set<String> seen = new HashSet<>(), repeated = new HashSet<>();
        for (int i = 0; i < s.length() - 10 + 1; i++) {
            String ten = s.substring(i, i + 10);
            if (!seen.add(ten)) repeated.add(ten);
        }
        return new ArrayList<>(repeated);
	}
	
	// Solution 1: Hash Table + Bit Manipulation: Time ~ O(MN) where M = 10, Space(2N)
	/*
	 * 给 DNA 编码（A - 00, C - 01, G - 10, T - 11），把 String s 变成 Binary Integer v
	 * 读取 sequence：首次连续读取 10 个 char；之后每次读取 1 个 char，将 v 左移两位（v << 2），
	 * 在最后两位加上新读的 char（v |= map[s.charAt(i) - 'A']），然后舍弃最高的两位
	 * （v &= ~(3 << 2*10)，注意是左移 20 不是 10，因为一个 char 对应两位）。
	 * 判断得到的 v 是否已经读过：这里巧妙地用了一行代码解决避免结果出现 duplicates
	 * if (!firstVisited.add(v) && secondVisited.add(v))
	 * 注意：HashSet 的 add() 返回 boolean，若元素存在则返回 false；
	 * 所以上述的条件是指：之前访问过该元素，且之后尚未第二次访问到，这样就得到一个 
	 * repeated sequene，将其放入 list，同时这样也避免了之后再次遇到同样的 sequence，
	 * 不会再将其放入 list，导致 duplicates。
	 */
	
	public static List<String> findRepeatedDnaSequences1(String s) {
		List<String> list = new ArrayList<>();
		if (s == null || s.length() <= 10) return list;
		Set<Integer> firstVisited = new HashSet<>();
		Set<Integer> secondVisited = new HashSet<>();
		char[] map = new char[26];
		map['A' - 'A'] = 0;
		map['C' - 'A'] = 1;
		map['G' - 'A'] = 2;
		map['T' - 'A'] = 3;
		
		int len = 10;
		for (int i = 0; i < s.length() - len + 1; i++) {
			int v = 0;
			for (int j = i; j < i + len; j++) {
				v <<= 2;
				v |= map[s.charAt(j) - 'A'];
			}
			if (!firstVisited.add(v) && secondVisited.add(v)) {
				list.add(s.substring(i, i + len));
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		System.out.println(findRepeatedDnaSequences("AAAAAAAAAAA"));
		System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
	}
	
	// Solution 2
	public List<String> findRepeatedDnaSequences2(String s) {
		List<String> list = new ArrayList<>();
		Set<Integer> firstVisited = new HashSet<>();
		Set<Integer> secondVisited = new HashSet<>();
		char[] map = new char[26];
		map['A' - 'A'] = 0;
		map['C' - 'A'] = 1;
		map['G' - 'A'] = 2;
		map['T' - 'A'] = 3;
		
		int len = 10, v = 0;
		for (int i = 0; i < s.length(); i++) {
			v <<= 2;
			v |= map[s.charAt(i) - 'A']; // add 2 bits at the end
			if (i == len - 1) firstVisited.add(v);
			else if (i > len - 1) {
				v &= ~(3 << 2 * len); // drop 2 bits at the highest place
				if (!firstVisited.add(v) && secondVisited.add(v))
					list.add(s.substring(i - len + 1, i + 1));
			}
		}
		return list;
	}
}

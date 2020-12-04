package leetcode.hashtable;

import java.util.*;
import java.io.*;

/**
 * Write code that takes as input parameters, two directory paths
 * The code should compare these two directories and return true if the directories are the same
 * @author yutian
 * @since Dec 19, 2015
 */
public class SameDirectory {

	public static void main(String[] args) {
		File dir1 = new File("/Users/yutian/Desktop/ns2");
		File dir2 = new File("/Users/yutian/Desktop/imwrite");
		System.out.println(isSame(dir1, dir2));
	}
	
	public static boolean isSame(File dir1, File dir2) {
		HashSet<String> s1 = new HashSet<String>();
		HashSet<String> s2 = new HashSet<String>();
		getAllFiles(dir1, s1);
		for (String s: s1) {
			System.out.println(s);
		}
		getAllFiles(dir2, s2);
		for (String s: s2) {
			System.out.println(s);
		}
		if (s1.size() != s2.size()) {
			return false;
		}
		return s1.containsAll(s2);
	}
	
	
	private static void getAllFiles(File dir, HashSet<String> s) {
		File[] listOfFiles = dir.listFiles();
		if (listOfFiles.length == 0) {
			return;
		}
		for (File f: listOfFiles) {
			if (f.isFile()) {
				s.add(f.getName());
			} else if (f.isDirectory()) {
				getAllFiles(f, s);
			}
		}
	}
}

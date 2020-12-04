package leetcode.others;

import java.util.ArrayList;
import java.util.List;

/**
 * 第一题是之前在地里看到的面经，给出起始时间和终止时间，格式"HH:MM:SS"，
 * 判断这个时间段内（包括起始时间和终止时间在内）的所有时间中所用数字个数<=2的个数。
 * 举个例子就是：起始时间"15:11:00" 终止时间"15:11:15" 则程序应该返回2，
 * 因为这个区间内只有"15:11:11"和"15:11:15"满足条件。程序不要求时间和空间复杂度
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=165857&extra=page%3D3%26filter%3Dsortid%26sortid%3D311%26sortid%3D311
 * @author yutian
 * @since Jan 21, 2016
 */
public class Time {
	
	
	public static class Timer {
		int hour;
		int min;
		int sec;
		Timer(int h, int m, int s) {
			hour = h;
			min = m;
			sec = s;
		}
	}
	
	static List<String> backup = new ArrayList<>();
	static int count = 0;
	static Timer start;
	static Timer end;
	
	public static int get(String s1, String s2) {
		String[] st = s1.split(":");
		String[] en = s2.split(":");
		start = new Timer(Integer.parseInt(st[0]), Integer.parseInt(st[1]), Integer.parseInt(st[2]));
		end = new Timer(Integer.parseInt(en[0]), Integer.parseInt(en[1]), Integer.parseInt(en[2]));
		for (int h = start.hour; h <= end.hour; h++) {
			if (h == 0 || h == 11 || h == 22) {
				int k = h % 10;
				for (int j = 0; j <= 9; j++) {
					int n = k * 10 + j;
					if (n < 24) {
						check(h, k, j);
					}
				}
			} else {
				int k = h % 10;
				int j = h / 10;
				check(h, k, j);
			}
		}
		return count;
	}

	private static void check(int h, int k, int j) {
		int[] temp = {k, j};
		for (int a: temp) {
			for (int b: temp) {
				for (int c: temp) {
					for (int d: temp) {
						int minute = a * 10 + b;
						int second = c * 10 + d;
						if (checkValid(h, minute, second)) {
							count++;
							backup.add(h + ":" + minute + ":" + second);
						}
					}
				}
			}
		}
	}

	private static boolean checkValid(int h, int minute, int second) {
		if (h == end.hour) 
			return minute >= start.min && minute <= end.min
				&& second >= start.sec && second <= end.sec;
		return minute >= 0 && minute < 60 && second >= 0 && second < 60;
	}
	
	public static void main(String[] args) {
		System.out.println(get("15:11:00", "15:11:15"));
		System.out.println(get("11:11:00", "12:11:15"));
	}

}

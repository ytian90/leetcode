package leetcode.string;
/**
 * 551. Student Attendance Record I
 * @author ytian
 *
 */
public class StudentAttendanceRecord {
	
	public static boolean checkRecord(String s) {
		return !(s.indexOf("A") != s.lastIndexOf("A") || s.contains("LLL"));
    }
	
	public static boolean checkRecord2(String s) {
		return !s.matches(".*LLL.*|.*A.*A.*");
	}

	public static void main(String[] args) {
		System.out.println(checkRecord("PPALLP"));
		System.out.println(checkRecord("PPALLL"));
	}

}

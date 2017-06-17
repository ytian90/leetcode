package string;
/**
 * Integer to English Words
 * @author yutian
 * @since Sep 16, 2015
 */
public class IntegerToEnglishWords {
	
	private final String[] lessThan20 = {"", "One", "Two", "Three", "Four", "Five", 
			"Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", 
			"Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	private final String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", 
			"Sixty", "Seventy", "Eighty", "Ninety"};
	private final String[] thousands = {"", "Thousand", "Million", "Billion"};
	
	public String numberToWords(int num) {
		if (num == 0) return "Zero";
		int i = 0;
		String words = "";
		while (num > 0) {
			if (num % 1000 != 0) {
				words = helper(num % 1000) + thousands[i] + " " + words;
			}
			num /= 1000;
			i++;
		}
		return words.trim();
	}

	private String helper(int num) {
		if (num == 0) return "";
		else if (num < 20)
			return lessThan20[num] + " ";
		else if (num < 100)
			return tens[num / 10] + " " + helper(num % 10);
		else 
			return lessThan20[num / 100] + " Hundred " + helper(num % 100);
	}
	
	/*
	public String[] digits = {"One", "Two", "Three", "Four", 
		"Five", "Six", "Seven", "Eight", "Nine"};
	public String[] teens = {"Eleven", "Twelve", "Thirteen", "Fourteen",
		"Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	public String[] tens = {"Ten", "Twenty", "Thirty", "Forty", "Fifty",
		"Sixty", "Seventy", "Eighty", "Ninety"};
	public String[] bigs = {"", "Thousand", "Million", "Billion"};
	    
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        if (num < 0) return "Negative " + numberToWords(-1 * num);
        int count = 0;
        String str = "";
        
        while (num > 0) {
            if (num % 1000 != 0) {
            	str = numberToWords100(num % 1000) + bigs[count] + " " + str;
            }
            num /= 1000;
            count++;
        }
        return str.trim();
    }
	    
    private String numberToWords100(int number) {
        String str = "";
        if (number >= 100) {
            str += digits[number / 100 - 1] + " Hundred ";
            number %= 100;
        }
        if (number >= 11 && number <= 19) {
            return str + teens[number - 11] + " ";
        } else if (number == 10 || number >= 20) {
            str += tens[number / 10 - 1] + " ";
            number %= 10;
        }
        if (number >= 1 && number <= 9) {
            str += digits[number - 1] + " ";
        }
        return str;
    }
    */
}

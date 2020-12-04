package leetcode.mj.houzz;

import java.util.Random;

public class PasswordGenerator {

    private static int NUMBER_DIGITS = 8;
    private static Random rand;

    public static String generate() {
        rand = new Random();
        String letterSet = "abcdefghijklmnopqrstuvwxyz";
        String letterSetCapital = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numberSet = "0123456789";
        String specialLetterSet = "!@#$%^&*";
        String charSet = letterSet + letterSetCapital + numberSet + specialLetterSet;

        StringBuilder sb = new StringBuilder();
        sb.append(letterSet.charAt(rand.nextInt(letterSet.length())));
        sb.append(letterSetCapital.charAt(rand.nextInt(letterSetCapital.length())));
        sb.append(numberSet.charAt(rand.nextInt(numberSet.length())));
        sb.append(specialLetterSet.charAt(rand.nextInt(specialLetterSet.length())));
        int left = NUMBER_DIGITS - sb.length();
        for (int i = 0; i < left; i++) {
            sb.append(charSet.charAt(rand.nextInt(charSet.length())));
        }

        char[] chars = sb.toString().toCharArray();
        shuffle(chars);

        return new String(chars);
    }

    private static void shuffle(char[] chars) {
        for (int i = chars.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            char t = chars[index];
            chars[index] = chars[i];
            chars[i] = t;
        }
    }

    public static void main(String[] args) {
        System.out.println(generate());
    }

}

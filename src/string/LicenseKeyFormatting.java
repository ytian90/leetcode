package string;

/**
 * 482. License Key Formatting
 */
public class LicenseKeyFormatting {

    public static String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) != '-') {
                if (sb.length() % (K + 1) == K) {
                    sb.append('-');
                }
                sb.append(S.charAt(i));
            }
        }
        return sb.reverse().toString().toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(licenseKeyFormatting("2-5g-3-J", 2));
    }
}

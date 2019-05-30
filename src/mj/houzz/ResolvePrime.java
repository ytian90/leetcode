package mj.houzz;

public class ResolvePrime {

    // ???
    public static void main (String[] args) {
        ResolvePrime test = new ResolvePrime();
        int[] nums = {1, 2, 3, 4, 17, 90};
        for (int i = 0; i < nums.length; i++) {
            System.out.println(test.resolvePrime(nums[i]));
        }
        String s = "rft567.908kih000000hh890jug678gtff567";
        String[] list = s.split("[^0-9]+");
        for (String a: list) {
            System.out.println(a);
        }

    }
    public String resolvePrime(int num) {
        int prime = 2;
        int total = num;
        StringBuilder sb = new StringBuilder("");
        if (num < prime) {
            return String.valueOf(num);
        }
        while (prime <= total) {
            while (total % prime == 0) {
                sb.append(prime);
                sb.append("*");
                total /= prime;
            }
            prime++;
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

}

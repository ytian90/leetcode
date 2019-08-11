package dynamicProgramming;

/**
 * 920. Number of Music Playlists
 */
public class NumberOfMusicPlaylists {

    public static int numMusicPlaylists(int N, int L, int K) {
        int mod = (int) Math.pow(10, 9) + 7;
        long[][] dp = new long[N + 1][L + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = i; j <= L; j++) {
                dp[i][j] = (dp[i - 1][j - 1] * (N - (i - 1))) % mod;
                if (i > K) {
                    dp[i][j] = (dp[i][j] + (dp[i][j - 1] * (i - K)) % mod) % mod;
                }
            }
        }
        return (int) dp[N][L];
    }

    public static void main(String[] args) {
        System.out.println(numMusicPlaylists(3, 3, 1));
//        System.out.println(numMusicPlaylists(2, 3, 0));
//        System.out.println(numMusicPlaylists(2, 3, 1));
    }
}

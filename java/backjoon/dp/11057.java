import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 10007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        int[] dp = new int[10];
        Arrays.fill(dp, 1);

        for (int len = 2; len <= n; len++) {
            for (int d = 1; d < 10; d++) {
                dp[d] = (dp[d] + dp[d - 1]) % MOD;
            }
        }

        int ans = 0;
        for (int d = 0; d < 10; d++) ans = (ans + dp[d]) % MOD;
        System.out.println(ans);
    }
}

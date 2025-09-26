import java.io.*;
import java.util.*;

public class Main {
    static FastScanner fs = new FastScanner();
    static int n, m;
    static int[] len;
    static int[] prefix;
    static long[] dp;
    static final long INF = (long)1e18;

    public static void main(String[] args) throws Exception {
        n = fs.nextInt();
        m = fs.nextInt();
        len = new int[n + 1];
        prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            len[i] = fs.nextInt();
            prefix[i] = prefix[i - 1] + len[i];
        }

        dp = new long[n + 2];
        Arrays.fill(dp, INF);
        dp[n + 1] = 0;

        for (int i = n; i >= 1; i--) {
            for (int j = i; j <= n; j++) {
                int width = (prefix[j] - prefix[i - 1]) + (j - i);
                if (width > m) break;

                long cost = (j == n) ? 0 : (long)(m - width) * (m - width);
                dp[i] = Math.min(dp[i], cost + dp[j + 1]);
            }
        }

        System.out.println(dp[1]);
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() throws Exception {
            while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
        int nextInt() throws Exception { return Integer.parseInt(next()); }
    }
}

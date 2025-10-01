import java.io.*;
import java.util.*;

public class Main {

    static FastScanner fs = new FastScanner();
    static String s;

    static int m;
    static int[] L, R, C;
    static long[][] dp;
    static boolean[][] vis;

    static final long INF = (long) 1e18;

    public static void main(String[] args) throws Exception {
        s = fs.next();

        List<Integer>[] pos = (List<Integer>[]) new List[26];
        for (int i = 0; i < 26; i++) pos[i] = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            pos[s.charAt(i) - 'a'].add(i);
        }

        List<Integer> order = new ArrayList<>();
        for (int ch = 0; ch < 26; ch++) if (!pos[ch].isEmpty()) order.add(ch);
        Collections.sort(order);

        m = order.size();
        if (m == 0) {
            System.out.println(0);
            return;
        }

        L = new int[m];
        R = new int[m];
        C = new int[m];

        for (int t = 0; t < m; t++) {
            int ch = order.get(t);
            List<Integer> xs = pos[ch];
            Collections.sort(xs);
            L[t] = xs.get(0);
            R[t] = xs.get(xs.size() - 1);
            C[t] = xs.size();
        }

        dp = new long[m][2];
        vis  = new boolean[m][2];

        int startPos = 0;

        long ans = Math.min(solve(m - 1, 0, startPos),solve(m - 1, 1, startPos));
        System.out.println(ans);
    }
  
    static long solve(int t, int endSide, int startPos) {
        if (vis[t][endSide]) return dp[t][endSide];

        long res;
        if (t == 0) {
            res = costToFinishFrom(startPos, t, endSide);
        } else {
            long fromLeft  = solve(t - 1, 0, startPos) + costToFinishFrom(L[t - 1], t, endSide);
            long fromRight = solve(t - 1, 1, startPos) + costToFinishFrom(R[t - 1], t, endSide);
            res = Math.min(fromLeft, fromRight);
        }

        vis[t][endSide] = true;
        return dp[t][endSide] = res;
    }

    static long costToFinishFrom(int startPos, int t, int endSide) {
        int l = L[t], r = R[t];
        long span = r - l;

        long toLeft  = Math.min(Math.abs(startPos - r) + span,
                                Math.abs(startPos - l) + 2 * span);
        long toRight = Math.min(Math.abs(startPos - l) + span,
                                Math.abs(startPos - r) + 2 * span);

        long move = (endSide == 0) ? toLeft : toRight;
        return move + C[t];
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() throws Exception {
            while (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }
    }
}

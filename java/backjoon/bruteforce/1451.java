import java.util.*;
import java.io.*;

class Main {

    static FastScanner fs = new FastScanner();
    static int n, m;
    static String tmp;
    static int[][] board = new int[52][52];
    static int[][] pSum = new int[52][52];

    static long ret = 0;

    public static void main(String[] args) throws Exception {
        n = fs.nextInt();
        m = fs.nextInt();
        for (int i = 1; i <= n; i++) {
            tmp = fs.next();
            for (int j = 1; j <= m; j++) {
                board[i][j] = tmp.charAt(j - 1) - '0';
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                pSum[i][j] = board[i][j] + pSum[i - 1][j] + pSum[i][j - 1] - pSum[i - 1][j - 1];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == n && j == m) break;

                if (i == n) {
                    twoSquareLeft(j, pSum[n][j]);
                } else if (j == m) {

                    twoSquareTop(i, pSum[i][m]);
                } else {

                    long a = pSum[i][j];
                    long b1 = pSum[i][m] - pSum[i][j];
                    long c1 = pSum[n][m] - a - b1;                    
                    ret = Math.max(ret, a * b1 * c1);

                    long b2 = pSum[n][j] - pSum[i][j];
                    long c2 = pSum[n][m] - a - b2;                    
                    ret = Math.max(ret, a * b2 * c2);
                }
            }
        }
        System.out.print(ret);
    }

    static void twoSquareLeft(int x, long a) {
        if (x >= m) {
            return; 
        }
        
        for (int k = x + 1; k <= m - 1; k++) {
            long b = pSum[n][k] - pSum[n][x];
            long c = pSum[n][m] - pSum[n][k];
            ret = Math.max(ret, a * b * c);
        }

        for (int r = 1; r <= n - 1; r++) {
            long b = pSum[r][m] - pSum[r][x];
            long c = pSum[n][m] - pSum[r][m] - pSum[n][x] + pSum[r][x];
            ret = Math.max(ret, a * b * c);
        }
    }

    static void twoSquareTop(int y, long a) {
        if (y >= n) {
            return;
        }
        
        for (int k = 1; k <= m - 1; k++) {
            long b = pSum[n][k] - pSum[y][k];
            long c = pSum[n][m] - pSum[n][k] - pSum[y][m] + pSum[y][k];
            ret = Math.max(ret, a * b * c);
        }

        for (int r = y + 1; r <= n - 1; r++) {
            long b = pSum[r][m] - pSum[y][m];
            long c = pSum[n][m] - pSum[r][m];
            ret = Math.max(ret, a * b * c);
        }
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() throws Exception {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        int nextInt() throws Exception {
            return Integer.parseInt(next());
        }
    }
}

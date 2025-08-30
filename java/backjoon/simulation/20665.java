import java.util.*;
import java.io.*;

class Main {

    static FastScanner fs = new FastScanner();

    static int n, t, p;

    static int[][] seat = new int[721][105];

    public static void main(String[] args) throws Exception {
        n = fs.nextInt();
        t = fs.nextInt();
        p = fs.nextInt();


        List<int[]> arr = new ArrayList<>(t);
        for (int i = 0; i < t; i++) {
            int sHHMM = fs.nextInt();
            int eHHMM = fs.nextInt();
            int s = toMinute(sHHMM);
            int e = toMinute(eHHMM);
            arr.add(new int[]{s, e, e - s, i});
        }

        arr.sort((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            if (a[2] != b[2]) return Integer.compare(a[2], b[2]);
            return Integer.compare(a[3], b[3]);
        });
      
        for (int[] cur : arr) {
            selectSeat(cur[0], cur[1]);
        }

        int ret = 0;
        for (int m = 0; m < 720; m++) {
            if (seat[m][p] != 1) ret++;
        }
        System.out.print(ret);
    }

    static void selectSeat(int s, int e) {
        boolean any = false;
        for (int i = 1; i <= n; i++) {
            if (seat[s][i] == 1) { 
              any = true; 
              break; 
            }
        }
        int idx = any ? findSeat(s) : 1;

        for (int m = s; m < e; m++) {
            seat[m][idx] = 1;
        }
    }

    static int findSeat(int s) {
        final int INF = 1_000_000;

        int[] leftDist = new int[n + 1];
        int[] rightDist = new int[n + 1];

        // 왼쪽 최근접 착석자 거리
        int prev = -INF;
        for (int i = 1; i <= n; i++) {
            if (seat[s][i] == 1) {
                prev = i;
                leftDist[i] = 0;
            } else {
                leftDist[i] = (prev < 1 ? INF : i - prev);
            }
        }

        // 오른쪽 최근접 착석자 거리
        int next = INF;
        for (int i = n; i >= 1; i--) {
            if (seat[s][i] == 1) {
                next = i;
                rightDist[i] = 0;
            } else {
                rightDist[i] = (next > n ? INF : next - i);
            }
        }

        int bestIdx = -1, bestMinDist = -1;
        for (int i = 1; i <= n; i++) {
            if (seat[s][i] == 1) {
              continue;
            }
            int nearest = Math.min(leftDist[i], rightDist[i]);
            if (nearest > bestMinDist) {
                bestMinDist = nearest;
                bestIdx = i;
            }
        }
        return bestIdx; 
    }

    static int toMinute(int hhmm) {
        int h = hhmm / 100;
        int m = hhmm % 100;
        return (h - 9) * 60 + m;
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

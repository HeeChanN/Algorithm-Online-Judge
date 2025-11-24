import java.io.*;
import java.util.*;

public class Main {
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
        int nextInt() throws IOException { return Integer.parseInt(next()); }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = fs.nextInt();
            arr[i][1] = fs.nextInt();
            arr[i][2] = i;
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        long possible = arr[0][0];
        long waiting = 0;
        int idx = 0;

        while (idx < n || !pq.isEmpty()) {
            while (idx < n && arr[idx][0] <= possible) {
                pq.offer(arr[idx]);
                idx++;
            }

            if (!pq.isEmpty()) {
                int[] cur = pq.poll();
                waiting = Math.max(waiting, possible - cur[0]);
                possible += cur[1];
            } else {
                possible = arr[idx][0];
            }
        }

        System.out.println(waiting);
    }
}

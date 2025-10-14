import java.io.*;
import java.util.*;

class Main {
    static FastScanner fs = new FastScanner();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int T = fs.nextInt();
        while (T-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();

            int[][] seg = new int[m][2];
            for (int i = 0; i < m; i++) {
                seg[i][0] = fs.nextInt(); // left
                seg[i][1] = fs.nextInt(); // right
            }
            Arrays.sort(seg, Comparator.comparingInt(a -> a[0]));


            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int p = 0;
            int ret = 0;

            for (int i = 1; i <= n; i++) {
                while (p < m && seg[p][0] <= i) {
                  pq.offer(seg[p++][1]);
                }
                while (!pq.isEmpty() && pq.peek() < i) {
                  pq.poll();
                }
                if (!pq.isEmpty()) {
                    pq.poll();
                    ret++;
                }
            }
            sb.append(ret).append('\n');
        }
        System.out.print(sb);
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

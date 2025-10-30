import java.io.*;
import java.util.*;

public class Main {

    static final int MAX_N = 401;
    static final int OFFSET = 401;
    static final int MAX_V = 802;
    static final int INF = 1_000_000_000;

    static int N, P;
    static List<Integer>[] adj = new ArrayList[802];
    static int[][] capacity = new int[802][802];
    static int[][] flow = new int[802][802];

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        N = fs.nextInt();
        P = fs.nextInt();

        for (int i = 0; i < 802; i++) {
          adj[i] = new ArrayList<>();
        }
      
        for (int i = 1; i <= N; i++) {
            int in = i;
            int out = i + 400;
            int cap = (i == 1 || i == 2) ? 987654321 : 1;
            adj[in].add(out);
            capacity[in][out] = cap;
        }

        for (int i = 0; i < P; i++) {
            int u = fs.nextInt();
            int v = fs.nextInt();
            adj[u+400].add(v);
            adj[v].add(u+400);
            adj[v+400].add(u);
            adj[u].add(v+400);
            capacity[u+400][v] = 1;
            capacity[v+400][u] = 1;
        }

        int source = 401;
        int sink = 2;
        System.out.println(maxFlow(source, sink));
    }

    static int maxFlow(int src, int sink) {
        int result = 0;
        int[] parent = new int[802];

        while (true) {
            Arrays.fill(parent, -1);
            Queue<Integer> q = new ArrayDeque<>();
            q.offer(src);
            parent[src] = src;
          
            while (!q.isEmpty() && parent[sink] == -1) {
                int u = q.poll();
                for (int v : adj[u]) {
                    if (parent[v] == -1 && capacity[u][v] - flow[u][v] > 0) {
                        parent[v] = u;
                        q.offer(v);
                    }
                }
            }

            if (parent[sink] == -1) {
              break;
            }

            for (int v = sink; v != src; v = parent[v]) {
                int u = parent[v];
                flow[u][v] += 1;
                flow[v][u] -= 1;
            }
            result++;
        }
        return result;
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
        int nextInt() throws IOException { return Integer.parseInt(next()); }
    }
}

import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        int to;
        int weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static List<Node>[] adj;
    static int[] dist;
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            adj[a].add(new Node(b, d));
            adj[b].add(new Node(a, d));
        }

        dist = new int[N + 1];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(bfs(start, end)).append('\n');
        }

        System.out.print(sb);
    }

    static int bfs(int start, int end) {
        Arrays.fill(dist, -1);
        Queue<Integer> q = new ArrayDeque<>();

        dist[start] = 0;
        q.add(start);

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == end) {
                return dist[cur];
            }

            for (Node next : adj[cur]) {
                if (dist[next.to] == -1) {
                    dist[next.to] = dist[cur] + next.weight;
                    q.add(next.to);
                }
            }
        }
        return -1;
    }
}

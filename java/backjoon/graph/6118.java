import java.io.*;
import java.util.*;

public class Main {
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            do c = readByte();
            while (c <= ' ');

            int sign = 1;
            if (c == '-') { sign = -1; c = readByte(); }

            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int N = fs.nextInt();
        int M = fs.nextInt();

        // 인접 리스트 (배열 기반) : head[u] -> (to, next) 연결
        int[] head = new int[N + 1];
        Arrays.fill(head, -1);

        int[] to = new int[2 * M];
        int[] next = new int[2 * M];
        int idx = 0;

        for (int i = 0; i < M; i++) {
            int a = fs.nextInt();
            int b = fs.nextInt();

            to[idx] = b; next[idx] = head[a]; head[a] = idx++;
            to[idx] = a; next[idx] = head[b]; head[b] = idx++;
        }

        // BFS
        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);

        int[] q = new int[N];
        int front = 0, back = 0;

        dist[1] = 0;
        q[back++] = 1;

        while (front < back) {
            int u = q[front++];
            for (int e = head[u]; e != -1; e = next[e]) {
                int v = to[e];
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q[back++] = v;
                }
            }
        }

        int maxDist = -1;
        for (int i = 1; i <= N; i++) {
            if (dist[i] > maxDist) maxDist = dist[i];
        }

        int minBarn = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] == maxDist) {
                count++;
                if (i < minBarn) minBarn = i;
            }
        }

        System.out.println(minBarn + " " + maxDist + " " + count);
    }
}

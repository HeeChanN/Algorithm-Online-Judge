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
            do {
                c = readByte();
            } while (c <= ' ' && c != -1);

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = readByte();
            }

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

        int F = fs.nextInt();
        int S = fs.nextInt();
        int G = fs.nextInt();
        int U = fs.nextInt();
        int D = fs.nextInt();

        if (S == G) {
            System.out.println(0);
            return;
        }

        int[] dist = new int[F + 1];
        Arrays.fill(dist, -1);

        // 최대 F개 정점을 한 번씩만 큐에 넣으니 배열 큐로 충분
        int[] q = new int[F + 1];
        int head = 0, tail = 0;

        dist[S] = 0;
        q[tail++] = S;

        while (head < tail) {
            int cur = q[head++];

            int up = cur + U;
            if (U > 0 && up <= F && dist[up] == -1) {
                dist[up] = dist[cur] + 1;
                if (up == G) break;
                q[tail++] = up;
            }

            int down = cur - D;
            if (D > 0 && down >= 1 && dist[down] == -1) {
                dist[down] = dist[cur] + 1;
                if (down == G) break;
                q[tail++] = down;
            }
        }

        if (dist[G] == -1) System.out.println("use the stairs");
        else System.out.println(dist[G]);
    }
}

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int N = fs.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) A[i] = fs.nextInt();

        int[] sorted = A.clone();
        Arrays.sort(sorted);

        // 값(1..1000) -> 정렬된 배열에서 그 값이 차지하는 위치들(오름차순)
        @SuppressWarnings("unchecked")
        ArrayDeque<Integer>[] pos = new ArrayDeque[1001];
        for (int j = 0; j < N; j++) {
            int v = sorted[j];
            if (pos[v] == null) pos[v] = new ArrayDeque<>();
            pos[v].addLast(j);
        }

        int[] P = new int[N];
        for (int i = 0; i < N; i++) {
            int v = A[i];
            P[i] = pos[v].pollFirst(); // 가장 작은 남은 위치를 배정 (사전순 최소)
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (i > 0) sb.append(' ');
            sb.append(P[i]);
        }
        System.out.println(sb);
    }

    // 빠른 입력
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream in) {
            this.in = in;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            do c = read(); while (c <= ' '); // skip spaces
            int sign = 1;
            if (c == '-') { sign = -1; c = read(); }
            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }
}

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int N = fs.nextInt();
        int M = fs.nextInt();

        int minPack = Integer.MAX_VALUE;
        int minSingle = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            int pack = fs.nextInt();
            int single = fs.nextInt();
            minPack = Math.min(minPack, pack);
            minSingle = Math.min(minSingle, single);
        }

        int onlyPack = ((N + 5) / 6) * minPack;             // ceil(N/6)
        int mix = (N / 6) * minPack + (N % 6) * minSingle;
        int onlySingle = N * minSingle;

        int answer = Math.min(onlyPack, Math.min(mix, onlySingle));
        System.out.println(answer);
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
            do { c = read(); } while (c <= ' '); // 공백 스킵

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }
}

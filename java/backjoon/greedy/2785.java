import java.io.*;
import java.util.*;

public class Main {

    // Fast input for large N
    private static class FastScanner {
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

        long nextLong() throws IOException {
            int c;
            do {
                c = readByte();
            } while (c <= ' ');

            long sign = 1;
            if (c == '-') {
                sign = -1;
                c = readByte();
            }

            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int N = (int) fs.nextLong();
        long[] a = new long[N];
        for (int i = 0; i < N; i++) a[i] = fs.nextLong();

        Arrays.sort(a);

        long remain = N;
        long ans = 0;

        for (int i = 0; i < N && remain > 1; i++) {
            if (remain == 2) {   
                ans += 1;
                break;
            }

            // remain >= 3
            long len = a[i];
            long use = Math.min(len, remain - 2); 

            ans += use;
            remain -= use;
            len -= use;

            if (len == 0) {

                remain -= 1;
            } else {
                ans += 1;
                break;
            }
        }

        System.out.println(ans);
    }
}

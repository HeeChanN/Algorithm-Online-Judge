import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        long Nl = fs.nextLong();
        long Sl = fs.nextLong();
        long Pl = fs.nextLong();

        int N = (int) Nl;
        long S = Sl;
        int P = (int) Pl;

        // 랭킹이 비어 있으면 무조건 1등
        if (N == 0) {
            System.out.println(1);
            return;
        }

        long[] arr = new long[N];
        for (int i = 0; i < N; i++) arr[i] = fs.nextLong();

        // 랭킹이 꽉 찼고 새 점수가 마지막 점수보다 크지 않으면 못 들어감
        if (N == P && S <= arr[N - 1]) {
            System.out.println(-1);
            return;
        }

        // 등수 계산: 내 점수보다 큰 점수 개수 + 1
        int rank = 1;
        for (int i = 0; i < N; i++) {
            if (S < arr[i]) rank++;
            else break; 
        }

        System.out.println(rank);
    }

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

        long nextLong() throws IOException {
            int c;
            do {
                c = readByte();
                if (c == -1) return Long.MIN_VALUE;
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
}

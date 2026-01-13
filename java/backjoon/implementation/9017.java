import java.io.*;
import java.util.*;

public class Main {

    // 빠른 입력
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream in) {
            this.in = in;
        }

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
        FastScanner fs = new FastScanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = fs.nextInt();
        while (T-- > 0) {
            int N = fs.nextInt();
            int[] team = new int[N];

            int[] count = new int[201];
            for (int i = 0; i < N; i++) {
                team[i] = fs.nextInt();
                count[team[i]]++;
            }

            boolean[] qualified = new boolean[201];
            for (int t = 1; t <= 200; t++) {
                if (count[t] == 6) qualified[t] = true;
            }

            int[] seen = new int[201];         // 자격 팀에서 해당 팀 몇 번째 선수인지(1~6)
            int[] sumFirst4 = new int[201];    // 1~4번째 점수 합
            int[] fifthScore = new int[201];   // 5번째 점수
            Arrays.fill(fifthScore, Integer.MAX_VALUE);

            int score = 1; // 자격 팀 선수에게만 부여되는 점수
            for (int i = 0; i < N; i++) {
                int tid = team[i];
                if (!qualified[tid]) continue;

                seen[tid]++;
                int k = seen[tid];

                if (k <= 4) sumFirst4[tid] += score;
                else if (k == 5) fifthScore[tid] = score;

                score++;
            }

            int bestTeam = -1;
            int bestSum = Integer.MAX_VALUE;
            int bestFifth = Integer.MAX_VALUE;

            for (int t = 1; t <= 200; t++) {
                if (!qualified[t]) continue;

                int s = sumFirst4[t];
                int f = fifthScore[t];

                if (s < bestSum || (s == bestSum && f < bestFifth)) {
                    bestSum = s;
                    bestFifth = f;
                    bestTeam = t;
                }
            }

            sb.append(bestTeam).append('\n');
        }

        System.out.print(sb.toString());
    }
}

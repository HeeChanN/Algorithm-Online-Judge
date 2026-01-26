import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        long[] c = new long[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());
            c[i] = B - A;
        }

        Arrays.sort(c);

        if (N % 2 == 1) {
            System.out.println(1);
        } else {
            long left = c[N / 2 - 1];
            long right = c[N / 2];
            System.out.println(right - left + 1);
        }
    }
}
